package eredua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import kontroladorea.Nagusia;

public class FitxategiakIrakurri {

	private static void stringakArrayListeanSartu(JSONObject objetua, ArrayList<Object> objetuak) {
		JSONObject EnplegatuObjetua = (JSONObject) objetua.get("enplegatu");
		JSONObject DepartamentuObjetua = (JSONObject) objetua.get("departamentu");
		if (EnplegatuObjetua != null) {
			int enpKod = 0;
			int soldata = Integer.valueOf((String.valueOf(EnplegatuObjetua.get("soldata"))));
			int zuzendariKod = Integer.valueOf((String.valueOf(EnplegatuObjetua.get("zuzendariKod"))));
			int departKod = Integer.valueOf((String.valueOf(EnplegatuObjetua.get("departKod"))));

			String AltaData = (String) EnplegatuObjetua.get("AltaData");
			String IzenAbizena = (String) EnplegatuObjetua.get("IzenAbizena");
			String ardura = (String) EnplegatuObjetua.get("ardura");
			String maila = (String) EnplegatuObjetua.get("maila");
			Enplegatu enplegatuBerria = new Enplegatu(enpKod, departKod, soldata, zuzendariKod, AltaData, IzenAbizena,
					ardura, maila);
			objetuak.add(enplegatuBerria);
		}
		if (DepartamentuObjetua != null) {
			String eraikuntza = (String) DepartamentuObjetua.get("eraikuntza");
			String DepartIzena = (String) DepartamentuObjetua.get("DepartIzena");
			int departKod = 0;
			Departamentu departamentuBerria = new Departamentu(departKod, DepartIzena, eraikuntza);
			objetuak.add(departamentuBerria);
		}

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Object> irakurriFitzategiaJSON(String ruta) {
		ArrayList<Object> objetuak = new ArrayList<Object>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(ruta)) {
			// JSON Irakurri
			Object obj = jsonParser.parse(reader);
			JSONArray employeeList = (JSONArray) obj;

			// Stringak arrayListean Sartu
			employeeList.forEach(obje -> stringakArrayListeanSartu((JSONObject) obje, objetuak));

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "JSON FITXATEGIA EZ DA AURKITU" );
			Nagusia.LOGGER.severe("JSON FITXATEGIA EZ DA AURKITU");
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "JSON FITXATEGIA TXARTO DAGO" );
			Nagusia.LOGGER.severe("JSON FITXATEGIA TXARTO DAGO");
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "JSON FITXATEGI EZ BATERAGARRIA" );
			Nagusia.LOGGER.severe("JSON FITXATEGI EZ BATERAGARRIA");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return objetuak;
	}

	public static ArrayList<Object> irakurriFitzategiaXML(String ruta) {
		ArrayList<Object> objetuenLista = new ArrayList<Object>();
		try {
			// Sortu Faktoria
			XMLReader reader = XMLReaderFactory.createXMLReader();
			// Lotu maneiatzailearekin
			reader.setContentHandler(new XMLManeiatzailea(objetuenLista));
			// Prozesatu liburuen fitxategia
			reader.parse(new InputSource(new FileInputStream(ruta)));
			// Badaukagu kargatuta liburuak eta orain inprimatuko ditugu

		} catch (SAXException e) {
			JOptionPane.showMessageDialog(null, "SAX EXZEPZIOA" );
			Nagusia.LOGGER.severe("SAX EXZEPZIOA");
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "XML FITXATEGIA TXARTO DAGO" );
			Nagusia.LOGGER.severe("XML FITXATEGIA TXARTO DAGO");
			e.printStackTrace();
		}
		System.out.println();
		return objetuenLista;
	}

	public static ArrayList<Object> irakurriFitzategiaCSV(String ruta) {
		ArrayList<Object> objetuenLista = new ArrayList<Object>();
		try (Reader reader = Files.newBufferedReader(Paths.get(ruta));) {
			CsvToBean<CSVobjetua> csvToBean = new CsvToBeanBuilder<CSVobjetua>(reader).withType(CSVobjetua.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVobjetua> csvUserIterator = csvToBean.iterator();
		
			while (csvUserIterator.hasNext()) {
				CSVobjetua csvObjetua = csvUserIterator.next();
				if (csvObjetua.getDepartIzena() != null) {
					Departamentu departamentuBerria = new Departamentu();
					departamentuBerria.setEraikuntza(csvObjetua.getEraikuntza());
					departamentuBerria.setDepartIzena(csvObjetua.getDepartIzena());
					objetuenLista.add(departamentuBerria);
				} else if (csvObjetua.getIzenAbizena() != null) {
					Enplegatu enplegatuBerria = new Enplegatu();
					enplegatuBerria.setIzenAbizena(csvObjetua.getIzenAbizena());
					enplegatuBerria.setSoldata(csvObjetua.getSoldata());
					enplegatuBerria.setAltaData(csvObjetua.getAltaData());
					enplegatuBerria.setMaila(csvObjetua.getMaila());
					enplegatuBerria.setDepartKod(csvObjetua.getDepartKod());
					objetuenLista.add(enplegatuBerria);
				}
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "XML FITXATEGIA TXARTO DAGO" );
			Nagusia.LOGGER.severe("XML FITXATEGIA TXARTO DAGO");
			e.printStackTrace();
		}
		return objetuenLista;
	}
}
