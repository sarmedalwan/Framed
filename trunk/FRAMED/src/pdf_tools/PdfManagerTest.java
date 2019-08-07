package pdf_tools;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PdfManagerTest {
    private PdfManager textExtractor;

    @Before
    public void createDefaultExtractor(){
        textExtractor = new PdfManager();

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
        ArrayList<String> list = textExtractor.getListOfPdfFilesInFolder("src/resources/");

        assertTrue(!list.isEmpty());
        assertEquals("src\\resources\\test.pdf",list.get(0));
        assertEquals("src\\resources\\test2.pdf",list.get(1));
    }

    @Test
    public void testgettingTextFromMultipleFiles(){
        ArrayList<String> texts = textExtractor.getTextFromMultipleFiles("src/resources/");

        assertTrue(!texts.isEmpty());
        assertEquals("Hello this is a dummy", texts.get(0));
        assertEquals("Hello this is a dummy", texts.get(1));
    }
}