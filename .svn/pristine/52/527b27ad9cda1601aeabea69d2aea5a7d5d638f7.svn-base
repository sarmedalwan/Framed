package CountWords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WordFreq {
    public String[][] pdfwordlist;
    public List<String> csvlist;

    public WordFreq(String[][] pdfl) {
        this.pdfwordlist = pdfl;

    }

    public List<String> readcsv() {
        String csvFile = "";
        BufferedReader bufRead = null;
        String line = "";
        String csvSplitting = ",";
        try {
            bufRead = new BufferedReader(new FileReader(csvFile));
            while ((line = bufRead.readLine()) != null) {
                for (int i = 0; i < line.split(csvFile).length; i++) {
                    String[] splittedLine = line.split(csvSplitting);
                    csvlist.add(splittedLine[i]);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
