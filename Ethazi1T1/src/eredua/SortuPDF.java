package eredua;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.*;

import java.io.*;

/**
 * Example of using the iText library to work with PDF documents on Java, lets
 * you create, analyze, modify and maintain documents in this format. Ejemplo de
 * uso de la librería iText para trabajar con documentos PDF en Java, nos
 * permite crear, analizar, modificar y mantener documentos en este formato.
 *
 * @author xules You can follow me on my website http://www.codigoxules.org/en
 *         Puedes seguirme en mi web http://www.codigoxules.org
 */
public class SortuPDF {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	/**
	 * We create a PDF document with iText using different elements to learn to use
	 * this library. Creamos un documento PDF con iText usando diferentes elementos
	 * para aprender a usar esta librería.
	 * 
	 * @param pdfNewFile <code>String</code> pdf File we are going to write. Fichero
	 *                   pdf en el que vamos a escribir.
	 */
	public void createPDF(File pdfNewFile) {
		// Aquí introduciremos el código para crear el PDF.
		// We create the document and set the file name.
		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("No such file was found to generate the PDF "
						+ "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
			}
			document.open();

			// AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
			// Añadimos los metadatos del PDF
			document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
			document.addSubject("Using iText (usando iText)");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Código Xules");
			document.addCreator("Código Xules");
			// First page
			// Primera página
			Chunk chunk = new Chunk("This is the title", chapterFont);
			chunk.setBackground(BaseColor.GRAY);
			//Creemos el primer capítulo
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph("This is the paragraph", paragraphFont));
			document.add(chapter);
			// Segunda página - Algunos elementos
            Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Some elements (Añadimos varios elementos)")), 1);
            Paragraph paragraphS = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
            // Subrayando un párrafo por iText
            Paragraph paragraphE = new Paragraph("This line will be underlined with a dotted line (Está línea será subrayada con una línea de puntos).");
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            paragraphE.add(dottedline);
            chapSecond.addSection(paragraphE);
            Section paragraphMoreS = chapSecond.addSection(paragraphS);
            // List by iText (listas por iText)
            String text = "test 1 2 3 ";
            for (int i = 0; i < 5; i++) {
                text = text + text;
            }
            List list = new List(List.UNORDERED);
            ListItem item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            text = "a b c align ";
            for (int i = 0; i < 5; i++) {
                text = text + text;
            }
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            text = "supercalifragilisticexpialidocious ";
            for (int i = 0; i < 3; i++) {
                text = text + text;
            }
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            paragraphMoreS.add(list);
            document.add(chapSecond);
            
            
            
			document.close();
			System.out.println("Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}

	}
}