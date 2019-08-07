package word_pdf_frequency;

import compute_similarities.PDF;
import org.junit.Before;
import org.junit.Test;
import pdf_tools.PdfManager;

import java.util.*;

//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class WordFrequencyCounterTest {

    private WordFrequencyCounter counter;

    @Before
    public void setUp() {
        counter = new WordFrequencyCounter();
    }

    @Test
    public void testAddIgnoredWords() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("the");
        list.add("be");
        counter.addIgnoredWords(list);
        counter.addIgnoredWords("JTest");
        assertEquals(4, counter.getIgnoreList().size());
    }

    @Test
    public void testClearIgnoredWords() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Obfuscation");
        list.add("Word");
        list.add("Condemn");
        counter.addIgnoredWords(list);
        counter.clearIgnoredWords();
        assertEquals(0, counter.getIgnoreList().size());
    }

    @Test
    public void testPdfWordCounter() {
        PDF pdf=new PDF();
        ArrayList<String> listigno = new ArrayList<>();
        listigno.add("a");
        listigno.add("the");
        listigno.add("be");
        counter.addIgnoredWords(listigno);
        ArrayList<String> list = new ArrayList<>();
        list.add("be");
        list.add("Word");
        list.add("Condemn");
        pdf.setWords(list);
        assertEquals(2, counter.calculateFrequenciesForPdf(pdf).size());
    }

    @Test
    public void testGetAllPdfCounterArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Obfuscation");
        list.add("Word");
        list.add("Condemn");
        PDF pdf=new PDF();
        pdf.setWords(list);

        counter.addIgnoredWords("Obfuscation");
        counter.calculateFrequenciesForPdf(pdf);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("O");
        list1.add("W");
        list1.add("C");
        PDF pdf1=new PDF();
        pdf.setWords(list1);
        counter.addIgnoredWords("O");
        counter.calculateFrequenciesForPdf(pdf1);
        Map<String, Integer>[] array = counter.getAllPdfCounterArray();
        assertEquals(0, array.length);
        assertFalse(Arrays.asList(array).contains("Obfuscation"));
    }

    @Test
    public void testcalculatingfrequenciesForMultiplePdfs() {
        HashMap<String, Integer> expectedMap = new HashMap<>();

        expectedMap.put("dummy", 1);
        PdfManager manager = new PdfManager();
        ArrayList<PDF> pdfs = manager.getTextFromMultipleFiles("src/resources/");
        counter.calculateFrequenciesForMultiplePdfs(pdfs, "src/resources/5000CommonWords.csv");

        assertTrue(pdfs.size() != 0);
        PDF firstPDf = pdfs.get(0);
        assertTrue(firstPDf.getWordFrequencies().size() != 0);
        assertEquals(expectedMap, firstPDf.wordFrequencies);


    }


}
