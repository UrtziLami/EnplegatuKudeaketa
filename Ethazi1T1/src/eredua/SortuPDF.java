package eredua;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.*;

import java.io.*;
import java.util.ArrayList;

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
	public static void createPDF(File pdfNewFile) {
		// Aquí introduciremos el código para crear el PDF.
		// We create the document and set the file name.
		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document(PageSize.A4.rotate());
			try {
				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
			}
			document.open();
			// AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
			// Añadimos los metadatos del PDF
			document.addTitle("Txostenak");
			document.addSubject("Erregistroen datuak.");
			document.addKeywords("Enplegatuak eta Departamentuak");
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
			columnHeaderEnp = new PdfPCell(new Phrase("EnplegatuKod",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("IzenAbizena",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("DepartKod",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Soldata",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Ardura",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("AltaData",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("ZuzendariKod",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Maila",smallBold));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			tableEnp.setHeaderRows(1);
			// Rellenamos las filas de la tabla.
			for (Enplegatu enp : enpak) {
				tableEnp.addCell(new Phrase(String.valueOf(enp.getEnpKod()),letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getIzenAbizena()),letraTxikia));
				tableEnp.addCell(new Phrase(String.valueOf(enp.getDepartKod()),letraTxikia));
				tableEnp.addCell(new Phrase(String.valueOf(enp.getSoldata()),letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getArdura()),letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getAltaData()),letraTxikia));
				tableEnp.addCell(new Phrase(String.valueOf(enp.getZuzendariKod()),letraTxikia));
				tableEnp.addCell(new Phrase(lehenengoaMayus(enp.getMaila()),letraTxikia));
			}
			// Añadimos la tabla
			chapEnp.add(tableEnp);
			// Añadimos el elemento con la tabla.
			document.add(chapEnp);
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
			columnHeader = new PdfPCell(new Phrase("DepartamentuKod"));
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
				table.addCell(new Phrase(String.valueOf(dept.getDepartKod()),letraTxikia));
				table.addCell(new Phrase(lehenengoaMayus(dept.getDepartIzena()),letraTxikia));
				table.addCell(new Phrase(lehenengoaMayus(dept.getEraikuntza()),letraTxikia));
			}
			// Añadimos la tabla
			chapDept.add(table);
			// Añadimos el elemento con la tabla.
			document.add(chapDept);
			document.close();
			System.out.println("Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}

	}
	
	
	private static String lehenengoaMayus (String sarreraStrig) {
		String s =sarreraStrig;
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