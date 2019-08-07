package compute_similarities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PDFTest {

    PDF pdf;

    @Before
    public void createDefaultPdf(){
        HashMap<String, Integer> words = new HashMap<>();
        words.put("a", 1);
        words.put("b" , 10);
        pdf =  new PDF("test.pdf", words, null);
    }

    @Test
    public void testGetName() {
        assertEquals("test.pdf", pdf.getName());
    }

    @Test
    public void testSetName() {
        pdf.setName("testName.pdf");
        assertEquals("testName.pdf", pdf.getName());
    }

    @Test
    public void testGetWordFrequencies() {
        HashMap<String, Integer> pdfWords = pdf.getWordFrequencies();
        assertTrue(!pdfWords.isEmpty());
        assertTrue(pdfWords.containsKey("a"));
        assertTrue(pdfWords.containsKey("b"));
    }

    @Test
    public void testSetWordFrequencies() {
        HashMap<String, Integer> newWords = new HashMap<>();
        newWords.put("c", 2);

        pdf.setWordFrequencies(newWords);

        assertTrue(!pdf.getWordFrequencies().isEmpty());
        assertTrue(pdf.getWordFrequencies().containsKey("c"));
        assertFalse(pdf.getWordFrequencies().containsKey("a"));
    }

    @Test
    public void testSettingAndGettingWords(){
        ArrayList<String> words = new ArrayList<>(Arrays.asList("a", "b", "c"));

        pdf.setWords(words);
        assertTrue(!pdf.getWords().isEmpty());
        assertEquals("a", pdf.getWords().get(0));
    }
}