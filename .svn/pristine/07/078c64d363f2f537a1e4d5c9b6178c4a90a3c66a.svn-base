import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class WordFrequencyCounterTest {

    WordFrequencyCounter counter;

    @Before
    public void setUp(){
        counter=new WordFrequencyCounter();
    }

    @Test
    public void testAddIgnoredWord(){
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("the");
        list.add("be");
        counter.addIgnoredWord(list);
        counter.addIgnoredWord("JTest");
        assertEquals(4,counter.getIgnoreList().size());
    }

    @Test
    public void testClearIgnoredWords(){
        ArrayList<String> list=new ArrayList<>();
        list.add("Obfuscation");
        list.add("Word");
        list.add("Condemn");
        counter.addIgnoredWord(list);
        counter.clearIgnoredWords();
        assertEquals(0,counter.getIgnoreList().size());
    }

    @Test
    public void testAddArray(){
        ArrayList<String> list=new ArrayList<>();
        list.add("Obfuscation");
        list.add("Word");
        list.add("Condemn");
        counter.addArray(list);
        assertEquals(3,list.size());
    }

    @Test
    public void testGetArray(){
        ArrayList<String> list=new ArrayList<>();
        list.add("Obfuscation");
        list.add("Word");
        list.add("Condemn");
        counter.addIgnoredWord("Obfuscation");
        counter.addArray(list);
        ArrayList<String> list1=new ArrayList<>();
        list1.add("O");
        list1.add("W");
        list1.add("C");
        counter.addIgnoredWord("O");
        counter.addArray(list);
        Map<String,Integer>[] array = counter.getArray();
        assertEquals(2, array.length);
        assertFalse(Arrays.asList(array).contains("Obfuscation"));
    }















}
