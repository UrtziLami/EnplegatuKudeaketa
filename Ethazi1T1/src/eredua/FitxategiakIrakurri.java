package eredua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.opencsv.CSVReader;

import kontroladorea.Nagusia;

public class FitxategiakIrakurri {

	private static void stringakArrayListeanSartu(JSONObject objetua, ArrayList<Object> objetuak) {
		JSONObject EnplegatuObjetua = (JSONObject) objetua.get("enplegatu");
		JSONObject DepartamentuObjetua = (JSONObject) objetua.get("departamentu");
		if (EnplegatuObjetua != null) {
			int enpKod = (int) EnplegatuObjetua.get("enpKod");
			int soldata = (int) EnplegatuObjetua.get("soldata");
			int zuzendariKod = (int) EnplegatuObjetua.get("zuzendariKod");
			int departKod = (int) EnplegatuObjetua.get("departKod");

			Date AltaData = (Date) EnplegatuObjetua.get("AltaData");
			String IzenAbizena = (String) EnplegatuObjetua.get("IzenAbizena");
			String ardura = (String) EnplegatuObjetua.get("ardura");
			String maila = (String) EnplegatuObjetua.get("maila");
			Enplegatu enplegatuBerria = new Enplegatu(enpKod, departKod, soldata, zuzendariKod, AltaData, IzenAbizena,
					ardura, maila);
			objetuak.add(enplegatuBerria);
		}
		if (DepartamentuObjetua != null) {
			String eraikuntza = (String) EnplegatuObjetua.get("eraikuntza");
			String DepartIzena = (String) EnplegatuObjetua.get("DepartIzena");
			int departKod = (int) EnplegatuObjetua.get("departKod");
			Departamentu departamentuBerria = new Departamentu(departKod, eraikuntza, DepartIzena);
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
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ParseException e) {
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
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		return objetuenLista;
	}

	public static ArrayList<String> irakurriFitzategiaCSV(String ruta) {
		ArrayList<String> Oharrak = new ArrayList<String>();
		try (Reader reader = Files.newBufferedReader(Paths.get(ruta)); CSVReader csvReader = new CSVReader(reader);) {

			String[] nextRecord;
			int i = 1;
			while ((nextRecord = csvReader.readNext()) != null) {
				if (i > 1) {
					Oharrak.add("data : " + nextRecord[0]);
					Oharrak.add("ordua : " + nextRecord[1]);
					Oharrak.add("nori : " + nextRecord[2]);
					Oharrak.add("nork : " + nextRecord[3]);
					Oharrak.add("titulua : " + nextRecord[4]);
					Oharrak.add("edukia : " + nextRecord[5]);
					Oharrak.add("==========================");
				}
				i++;
			}
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "File no found");
			Nagusia.LOGGER.severe(fnfe.getMessage());

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File no found");

		}

		return Oharrak;
	}
}
