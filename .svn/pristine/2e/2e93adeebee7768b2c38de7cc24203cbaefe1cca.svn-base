package pdf_tools;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PdfManager {

    PDFTextStripper textStripper;

    PdfManager(){
        try {
            initializeExtractor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeExtractor() throws IOException {
        this.textStripper = new PDFTextStripper();
    }

    public String getTextFromPdfFile(String filePath){
        try {
            PDDocument pdfDocument = PDDocument.load(new File(filePath));
            return textStripper.getText(pdfDocument).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getListOfPdfFilesInFolder(String folderPath){
        ArrayList<String> listOfPdfDocuments = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for(File file : files){
            listOfPdfDocuments.add(file.getPath());
        }

        return listOfPdfDocuments;
    }

    public ArrayList<String> getTextFromMultipleFiles(String folderPath){
        ArrayList<String> pathsToFiles = this.getListOfPdfFilesInFolder(folderPath);

        ArrayList<String> result = new ArrayList<>();

        for(String path : pathsToFiles){
            String text = getTextFromPdfFile(path);
            result.add(text);
        }

        return result;
    }
}
