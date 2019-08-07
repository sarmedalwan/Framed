package csv_ignored_words_reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IgnoredWordsCsvReader {
    public static ArrayList<String> csvlist;
    String csvPath;

    /**
     * This method reads the each word from a csv file by splitting the lines and adds each word in a list of Strings
     * @return a list containing all the words given from the CSV file. Each word inn the list ows a single position
     */
    //If you want to run the class WordFreqTest add the following as a parameter of readCsvFile() so will be readCsvFile(String csvPath) and
    // uncomment the third line(String csvFile = csvPath;) and also delete the first line (String csvFile = "src/res/5000CommonWords.csv";)
    public static ArrayList<String> readCsvFile(String filepath) {
        String csvFile = filepath;
        csvlist = new ArrayList<>();
        //String csvFile = csvPath;
        BufferedReader bufRead = null;
        String eachLine;
        String csvSplitting = ",";
        try {
            bufRead = new BufferedReader(new FileReader(csvFile));
            while ((eachLine = bufRead.readLine()) != null) {
                    csvlist.add(eachLine);
            }

            //if the specified file is not found, an exception will be catch and printed
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        } finally {
            {
                if (bufRead != null) {
                    try {
                        bufRead.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return csvlist;
    }
}
