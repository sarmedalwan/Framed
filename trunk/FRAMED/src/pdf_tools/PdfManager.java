package pdf_tools;

import compute_similarities.PDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PdfManager {

    PDFTextStripper textStripper;

    public PdfManager(){
        try {
            initializeExtractor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeExtractor() throws IOException {
        this.textStripper = new PDFTextStripper();
    }

    private File getFileFromPath(String path){
        return new File(path);
    }

    public String getTextFromPdfFile(String filePath){
        try {
            PDDocument pdfDocument = PDDocument.load(getFileFromPath(filePath));
            String text = textStripper.getText(pdfDocument).trim();
            pdfDocument.close();
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isFilePdf(String path){
        return path.endsWith(".pdf");
    }

    public ArrayList<String> getListOfPdfFilesInFolder(String folderPath){
        ArrayList<String> listOfPdfDocuments = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for(File file : files){
            String path = file.getPath();
            if(isFilePdf(path)){
                listOfPdfDocuments.add(path);
            }

        }

        return listOfPdfDocuments;
    }

    public ArrayList<PDF> getTextFromMultipleFiles(String folderPath){
        ArrayList<String> pathsToFiles = this.getListOfPdfFilesInFolder(folderPath);

        ArrayList<PDF> result = new ArrayList<>();

        for(String path : pathsToFiles){
            String text = getTextFromPdfFile(path);
            ArrayList<String> processedText = processText(text);
            PDF pdf = createPdfFromPath(path);
            pdf.setWords(processedText);
            pdf.setPath(path);
            result.add(pdf);
        }

        return result;
    }

    public PDF createPdfFromPath(String path){
        File file = getFileFromPath(path);
        PDF pdf = new PDF();
        pdf.setName(file.getName());

        return pdf;
    }

    public ArrayList<String> processText(String text){
        ArrayList<String> words = new ArrayList<>();

        String[] tokens = text.split("\\s+");

        for(String word : tokens) {
            String processWord = this.processWord(word);

            words.add(processWord);
        }

        return words;
    }

    public String processWord(String word){
        word = word.trim();
        word = word.toLowerCase();
        word = word.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\\\](?=\\s|$)", "");

        return word;
    }

    public void openPdfDocument(PDF pdf)
    {
        System.out.println(pdf.getPath());
        try {
            Desktop.getDesktop().open(new File(pdf.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PDF getPdfByName(ArrayList<PDF> pdfs, String name){
        for(PDF pdf : pdfs) {
            if(pdf.name.equals(name)) {
                return pdf;
            }
        }
        return null;
    }
}
