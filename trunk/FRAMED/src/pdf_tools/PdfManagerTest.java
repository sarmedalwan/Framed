package pdf_tools;

import compute_similarities.PDF;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PdfManagerTest {
    private PdfManager textExtractor;
    ArrayList<String> test1;
    ArrayList<String> test2;

    @Before
    public void createDefaultExtractor(){
        textExtractor = new PdfManager();
        test1 = new ArrayList<String>(
                Arrays.asList("hello", "this", "is", "a", "dummy"));
        test2 = new ArrayList<String>(
                Arrays.asList("hello", "this", "is", "a", "dummy"));

    }

    @Test
    public void testCreation(){
        assertTrue(textExtractor.textStripper != null);

    }

    @Test
    public void testTextExtraction(){
        String extractedText = textExtractor.getTextFromPdfFile("src/resources/test.pdf");
        assertEquals("Hello this is a dummy", extractedText);
    }

    @Test
    public void testgettingListOfPdfFilesInFolder() {
        ArrayList<String> listFull = textExtractor.getListOfPdfFilesInFolder("src/resources/");
        ArrayList<String> listEmpty = textExtractor.getListOfPdfFilesInFolder("src/resources/Empty");
        assertTrue(listEmpty.isEmpty());
        assertTrue(!listFull.isEmpty());
        assertEquals("src\\resources\\test.pdf",listFull.get(2));
        assertEquals("src\\resources\\test2.pdf",listFull.get(3));
    }

    @Test
    public void testgettingTextFromMultipleFiles(){
        ArrayList<PDF> pdfs = textExtractor.getTextFromMultipleFiles("src/resources/");

        assertTrue(!pdfs.isEmpty());
        assertTrue(pdfs.get(0).getClass() == PDF.class);
        assertEquals(test1, pdfs.get(2).getWords());
        assertEquals(test2, pdfs.get(3).getWords());
    }

    @Test
    public void testProcessingWord(){
        String testWord = "Asrimu.";
        String testWord2 = "Matt's";

        assertEquals("asrimu", textExtractor.processWord(testWord));
        assertEquals("matt's", textExtractor.processWord(testWord2));

    }

    @Test
    public void testProcessingText(){
        String testText = "Asrimu. Matt's harmonica. Andrei is not, here. I am 5.5 cm tall.";
        ArrayList<String>expected = new ArrayList<>(Arrays.asList("asrimu", "matt's", "harmonica", "andrei", "is", "not", "here", "i", "am", "5.5", "cm", "tall"));

        assertEquals(expected, textExtractor.processText(testText));
    }

    @Test
    public void createPdfFromPath() {
        PDF test = textExtractor.createPdfFromPath("src/resources/test.pdf");
        assertTrue(test.getClass() == PDF.class);
        assertEquals("test.pdf", test.getName());

    }


    @Test
    public void getPdfByName() {
        ArrayList<PDF> pdfs = textExtractor.getTextFromMultipleFiles("src/resources/");

        PDF pdf = textExtractor.getPdfByName(pdfs, "hello.pdf");

        assertEquals("hello.pdf", pdf.getName());
    }
}