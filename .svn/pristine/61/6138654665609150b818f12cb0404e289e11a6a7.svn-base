package compute_similarities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

import static compute_similarities.SortListOfPDFsAndCalculateSimilarities.*;

public class SortListOfPDFsAndCalculateSimilaritiesTest {

    HashMap<String, Integer> frequenciesForFirstPdfMap = new HashMap<>();
    HashMap<String, Integer> frequenciesForSecondPdfMap = new HashMap<>();
    HashMap<String, Integer> frequenciesForThirdPdfMap = new HashMap<>();

    ArrayList<PDF> pdfs =new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        PDF pdf1 = new PDF();
        PDF pdf2 = new PDF();
        PDF pdf3 = new PDF();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList("Test", "twenty", "twenty", "ten"));

        frequenciesForFirstPdfMap.put("Test",1);
        frequenciesForFirstPdfMap.put("twenty",2);
        frequenciesForFirstPdfMap.put("ten",1);
        pdf1.setWordFrequencies(frequenciesForFirstPdfMap);
        pdf1.setWords(myList);
        pdf1.setNonIgnoredWords(myList);

        frequenciesForSecondPdfMap.put("Test",1);
        frequenciesForSecondPdfMap.put("twenty",2);
        frequenciesForSecondPdfMap.put("ten",1);
        pdf2.setWordFrequencies(frequenciesForSecondPdfMap);
        pdf2.setWords(myList);
        pdf2.setNonIgnoredWords(myList);

        frequenciesForThirdPdfMap.put("Test",1);
        frequenciesForThirdPdfMap.put("twenty",2);
        frequenciesForThirdPdfMap.put("ten",1);
        frequenciesForThirdPdfMap.put("fourth",1);
        pdf3.setWordFrequencies(frequenciesForThirdPdfMap);
        pdf3.setWords(new ArrayList<>(Arrays.asList("Test", "twenty", "twenty", "ten", "fourth")));
        pdf3.setNonIgnoredWords(new ArrayList<>(Arrays.asList("Test", "twenty", "twenty", "ten", "fourth")));

        pdfs.add(pdf1);
        pdfs.add(pdf2);
        pdfs.add(pdf3);

    }

    @Test
    public void getSimilarityTest() throws Exception {
        PDF first = pdfs.get(0);
        PDF second = pdfs.get(1);
        PDF third = pdfs.get(2);

        assertEquals(1.0, getSimilarity(first,second), 0);
        assertEquals(0.8, getSimilarity(first, third),0);
        assertEquals(0.8, getSimilarity(second, third),0);
        assertEquals(1.0, getSimilarity(third, third),0);
    }

}