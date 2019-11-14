package eredua;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.*;

import kontroladorea.Nagusia;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Ejemplo de uso de la librería iText para trabajar con documentos PDF en Java,
 * nos permite crear, analizar, modificar y mantener documentos en este formato.
 */
public class SortuPDF {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static final Font letraTxikia = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

	private static ArrayList<Departamentu> deptak = new ArrayList<>();
	private static ArrayList<Enplegatu> enpak = new ArrayList<>();
	private static int deptKont = 0;
	private static int enpKont = 0;

	/**
	 * Creamos un documento PDF con iText usando diferentes elementos para aprender
	 * a usar esta librería.
	 * 
	 */
	public static void sortuPDFEnp(File fitxEnp) {
		// Aquí introduciremos el código para crear el PDF.
		// We create the document and set the file name.
		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document(PageSize.A4.rotate());
			try {
				PdfWriter.getInstance(document, new FileOutputStream(fitxEnp));
			} catch (FileNotFoundException fileNotFoundException) {
				Nagusia.LOGGER.severe("EZ DA AURKITU PDF-A, FITXATEGIA SORTZEKO");
				System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
			}
			document.open();
			// AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
			// Añadimos los metadatos del PDF
			document.addTitle("Txostenak");
			document.addSubject("Enplegatuen datuak.");
			document.addKeywords("Enplegatuak.");
			document.addAuthor("Urtzi Lamikiz, Aitor Nogales");
			document.addCreator("Urtzi Lamikiz");
			// Primera página
			// Usamos varios elementos para añadir título y subtítulo
			Anchor anchEnp = new Anchor("ENPLEGATUAK", chapterFont);
			Chapter chapEnp = new Chapter(new Paragraph(anchEnp), 1);
			chapEnp.add(Chunk.NEWLINE);
			Integer numColumnsEnp = 8;
			enpak = Selekzioak.ateraEnple();
			for (int i = 0; i < enpak.size(); i++) {
				enpKont++;
			}
			// Creamos la tabla.
			PdfPTable tableEnp = new PdfPTable(numColumnsEnp);
			// Ahora llenamos la tabla del PDF
			PdfPCell columnHeaderEnp;
			// Rellenamos las Columnas de la tabla.
			columnHeaderEnp = new PdfPCell(new Phrase("Enplegatua", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("IzenAbizena", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Departamentua", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Soldata", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Ardura", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("AltaData", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Zuzendaria", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Maila", smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			tableEnp.setHeaderRows(1);
			String depIzena, zuzIzena;
			// Rellenamos las filas de la tabla.
			for (Enplegatu enp : enpak) {
				depIzena = Selekzioak.deptIzena(enp.getDepartKod());
				zuzIzena = Selekzioak.zuzIzena(enp.getZuzendariKod());
				tableEnp.addCell(new Phrase(String.valueOf(enp.getEnpKod()), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getIzenAbizena()), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(depIzena), letraTxikia));
				tableEnp.addCell(new Phrase(String.valueOf(enp.getSoldata()), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getArdura()), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getAltaData()), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(zuzIzena), letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getMaila()), letraTxikia));
			}
			// Añadimos la tabla
			chapEnp.add(tableEnp);
			// Añadimos el elemento con la tabla.
			document.add(chapEnp);
			document.close();
			System.out.println("Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			JOptionPane.showMessageDialog(null, "EZ DA AURKITU PDF FITXATEGIA" );
			Nagusia.LOGGER.severe("EZ DA AURKITU PDF FITXATEGIA");
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}

	}

	public static void sortuPDFDep(File fitxDep) {
		try {
			Document document = new Document(PageSize.A4.rotate());
			try {
				PdfWriter.getInstance(document, new FileOutputStream(fitxDep));
			} catch (FileNotFoundException fileNotFoundException) {
				JOptionPane.showMessageDialog(null, "EZ DA AURKITU PDF-A, FITXATEGIA SORTZEKO" );
				Nagusia.LOGGER.severe("EZ DA AURKITU PDF-A, FITXATEGIA SORTZEKO");
				System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
			}
			document.open();
			// AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
			// Añadimos los metadatos del PDF
			document.addTitle("Txostenak");
			document.addSubject("Departamentuen datuak.");
			document.addKeywords("Departamentuak.");
			document.addAuthor("Urtzi Lamikiz, Aitor Nogales");
			document.addCreator("Urtzi Lamikiz");
			// Usamos varios elementos para añadir título y subtítulo
			Anchor anchDept = new Anchor("DEPARTAMENTUAK", chapterFont);
			Chapter chapDept = new Chapter(new Paragraph(anchDept), 2);
			chapDept.add(Chunk.NEWLINE);
			Integer numColumns = 3;
			deptak = Selekzioak.ateraDepart();
			for (int i = 0; i < deptak.size(); i++) {
				deptKont++;
			}
			// Creamos la tabla.
			PdfPTable table = new PdfPTable(numColumns);
			// Ahora llenamos la tabla del PDF
			PdfPCell columnHeader;
			// Rellenamos las Columnas de la tabla.
			columnHeader = new PdfPCell(new Phrase("Departamentua"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);
			columnHeader = new PdfPCell(new Phrase("DepartIzena"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);
			columnHeader = new PdfPCell(new Phrase("Eraikuntza"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);
			table.setHeaderRows(deptKont);
			// Rellenamos las filas de la tabla.
			for (Departamentu dept : deptak) {
				table.addCell(new Phrase(String.valueOf(dept.getDepartKod()), letraTxikia));
				table.addCell(new Phrase(lehenengoaMayus(dept.getDepartIzena()), letraTxikia));
				table.addCell(new Phrase(lehenengoaMayus(dept.getEraikuntza()), letraTxikia));
			}
			// Añadimos la tabla
			chapDept.add(table);
			// Añadimos el elemento con la tabla.
			document.add(chapDept);
			document.close();
			System.out.println("Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			JOptionPane.showMessageDialog(null, "EZ DA AURKITU PDF FITXATEGIA" );
			Nagusia.LOGGER.severe("EZ DA AURKITU PDF FITXATEGIA");
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}
	}

	private static String lehenengoaMayus(String sarreraStrig) {
		String s = sarreraStrig;
		if ((s == null) || (s.trim().length() == 0)) {
			return s;
		}
		s = s.toLowerCase();
		char[] cArr = s.trim().toCharArray();
		cArr[0] = Character.toUpperCase(cArr[0]);
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == ' ' && (i + 1) < cArr.length) {
				cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
			}
			if (cArr[i] == '-' && (i + 1) < cArr.length) {
				cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
			}
			if (cArr[i] == '\'' && (i + 1) < cArr.length) {
				cArr[i + 1] = Character.toUpperCase(cArr[i + 1]);
			}
		}
		return new String(cArr);
	}

}