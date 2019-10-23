package eredua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.opencsv.CSVReader;

import kontroladorea.Nagusia;

public class FitxategiakIrakurri {
	@SuppressWarnings("unchecked")
	public static ArrayList<String> irakurriFitzategiaJSON(String ruta) {
		ArrayList<String> Oharrak = new ArrayList<String>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(ruta)) {
			// JSON Irakurri
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;

			// Stringak arrayListean Sartu
			employeeList.forEach(ohar -> stringakArrayListeanSartu((JSONObject) ohar, Oharrak));

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return Oharrak;
	}

	public static ArrayList<String> irakurriFitzategiaXML(String ruta) {
		ArrayList<String> Oharrak = new ArrayList<String>();
		try {
			ArrayList<Enplegatu> enplegatuenLista = new ArrayList<Enplegatu>();
			// Sortu Faktoria
			XMLReader reader = XMLReaderFactory.createXMLReader();
			// Lotu maneiatzailearekin
			reader.setContentHandler(new XMLManeiatzailea(enplegatuenLista));
			// Prozesatu liburuen fitxategia
			reader.parse(new InputSource(new FileInputStream(ruta)));
			// Badaukagu kargatuta liburuak eta orain inprimatuko ditugu

		} catch (SAXException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		return Oharrak;
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
