package eredua;

import java.io.File;

public class FormularioakIdatzi {
	
	public static void pdfIdatzi() {
		SortuPDF generatePDFFileIText = new SortuPDF();
        generatePDFFileIText.createPDF(new File("C:\\Users\\Admin1\\Desktop\\Txostena.pdf"));
	}
	
	public static void txtIdatzi() {
		
	}

}
