package eredua;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLManeiatzailea extends DefaultHandler {
	private String balioa = null;
	private Enplegatu enplegatu;
	private Departamentu departamentu;
	
	private ArrayList<Object> ObjetuLista;

	public XMLManeiatzailea(ArrayList<Object> objetuak) {
		this.ObjetuLista = objetuak;
	}

	// Alde baterako aldagaiaren balioa garbitu.
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {

		balioa = null;

		// Elentua <liburua> bada isbn atributua irakurriko dugu
		if (localName.equals("enplegatu")) {
			enplegatu = new Enplegatu();
		}else if (localName.equals("departamentu")) {
			departamentu = new Departamentu();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// Balioa aldi baterako aldagai batean gordeko dugu
		balioa = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// Elementuaren arabera gordeko dugu irakurritako balioa dagokion liburu
		// objektuaren propietatean
		switch (localName) {
		case "zuzendariKod":
			enplegatu.setZuzendariKod(Integer.parseInt(balioa));
			break;
		case "soldata":
			enplegatu.setSoldata(Integer.parseInt(balioa));
			break;
		case "AltaData":
			try {
				enplegatu.setAltaData(new SimpleDateFormat("yyyy/MM/dd").parse(balioa).toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "IzenAbizena":
			enplegatu.setIzenAbizena(balioa);
			break;
		case "ardura":
			enplegatu.setArdura(balioa);
			break;
		case "maila":
			enplegatu.setMaila(balioa);
			break;
		case "DepartIzena":
			departamentu.setDepartIzena(balioa);
			break;
		case "eraikuntza":
			departamentu.setEraikuntza(balioa);
			break;
		case "departKod":
			enplegatu.setDepartKod(Integer.parseInt(balioa));
			departamentu.setDepartKod(Integer.parseInt(balioa));
			break;	
		case "enplegatu":
			ObjetuLista.add(enplegatu);
			break;
		case "departamentu":
			ObjetuLista.add(departamentu);
			break;
		}

	}

}
