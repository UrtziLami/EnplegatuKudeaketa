package eredua;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLManeiatzailea extends DefaultHandler {
	private String balioa = null;
	private Enplegatu enplegatu;
	private ArrayList<Enplegatu> EnplegatuLista;

	public XMLManeiatzailea(ArrayList<Enplegatu> oharrak) {
		this.EnplegatuLista = oharrak;
	}

	// Alde baterako aldagaiaren balioa garbitu.
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {

		balioa = null;

		// Elentua <liburua> bada isbn atributua irakurriko dugu
		if (localName.equals("enplegatu")) {
			enplegatu = new Enplegatu();
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
		case "data":
			enplegatu.setData(balioa);
			break;
		case "ordua":
			enplegatu.setOrduak(balioa);
			break;
		case "nori":
			enplegatu.setNori(balioa);
			break;
		case "nork":
			enplegatu.setNork(balioa);
			break;
		case "titulua":
			enplegatu.setTitulua(balioa);
			break;
		case "edukia":
			enplegatu.setEdukia(balioa);
			break;
		case "oharra":
			EnplegatuLista.add(enplegatu);
			break;
		}

	}

}
