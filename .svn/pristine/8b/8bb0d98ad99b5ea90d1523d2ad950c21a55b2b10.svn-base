package csv_ignored_words_reader;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IgnoredWordsCsvReaderTest {

    IgnoredWordsCsvReader csv;
    String csvFile;

    @Before
    public void setUp() {
        csv = new IgnoredWordsCsvReader();
    }

    @Test
    //giving the csv file as a parameter to the WordFreqCSV
    //To make the this test to run correctly, add a String parameter to the readCsv() in the IgnoredWordsCsvReader class
    public void testreadcsv(){
        csvFile = "src/resources/5000CommonWords.csv";
        assertEquals(5000, csv.readCsvFile(csvFile).size());
    }
}

