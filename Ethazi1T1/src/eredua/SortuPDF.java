package eredua;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Ejemplo de uso de la librer�a iText para trabajar con documentos PDF en Java,
 * nos permite crear, analizar, modificar y mantener documentos en este formato.
 */
public class SortuPDF {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	private static ArrayList<Departamentu> deptak = new ArrayList<>();
	private static ArrayList<Enplegatu> enpak = new ArrayList<>();
	private static int deptKont = 0;
	private static int enpKont = 0;

	/**
	 * Creamos un documento PDF con iText usando diferentes elementos para aprender
	 * a usar esta librer�a.
	 * 
	 */
	public static void createPDF(File pdfNewFile) {
		// Aqu� introduciremos el c�digo para crear el PDF.
		// We create the document and set the file name.
		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("No se encontr� el fichero para generar el pdf" + fileNotFoundException);
			}
			document.open();
			// AQU� COMPLETAREMOS NUESTRO C�DIGO PARA GENERAR EL PDF
			// A�adimos los metadatos del PDF
			document.addTitle("Txostenak");
			document.addSubject("Erregistroen datuak.");
			document.addKeywords("Enplegatuak eta Departamentuak");
			document.addAuthor("Urtzi Lamikiz, Aitor Nogales");
			document.addCreator("Urtzi Lamikiz");
			// Primera p�gina
			// Usamos varios elementos para a�adir t�tulo y subt�tulo
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
			columnHeaderEnp = new PdfPCell(new Phrase("EnplegatuKod"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("IzenAbizena"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("DepartKod"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Soldata"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Ardura"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("AltaData"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("ZuzendariKod"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			columnHeaderEnp = new PdfPCell(new Phrase("Maila"));
			columnHeaderEnp.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableEnp.addCell(columnHeaderEnp);
			tableEnp.setHeaderRows(enpKont);
			// Rellenamos las filas de la tabla.
			for (Enplegatu enp : enpak) {
				tableEnp.addCell(String.valueOf(enp.getEnpKod()));
				tableEnp.addCell(enp.getIzenAbizena());
				tableEnp.addCell(String.valueOf(enp.getDepartKod()));
				tableEnp.addCell(String.valueOf(enp.getSoldata()));
				tableEnp.addCell(enp.getArdura());
				tableEnp.addCell(enp.getAltaData());
				tableEnp.addCell(String.valueOf(enp.getZuzendariKod()));
				tableEnp.addCell(enp.getMaila());
			}
			// A�adimos la tabla
			chapEnp.add(tableEnp);
			// A�adimos el elemento con la tabla.
			document.add(chapEnp);
			// Usamos varios elementos para a�adir t�tulo y subt�tulo
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
				table.addCell(String.valueOf(dept.getDepartKod()));
				table.addCell(dept.getDepartIzena());
				table.addCell(dept.getEraikuntza());
			}
			// A�adimos la tabla
			chapDept.add(table);
			// A�adimos el elemento con la tabla.
			document.add(chapDept);
			document.close();
			System.out.println("Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}

	}
}