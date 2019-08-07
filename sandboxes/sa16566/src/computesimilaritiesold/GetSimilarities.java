package computesimilarities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetSimilarities {
    public ArrayList<ArrayList<Integer>> getSimilarities(ArrayList<HashMap<String, Integer>> pdfList){ //Receives ArrayList of Hashmaps, declares method as Hashmap of Hashmaps
        ArrayList<ArrayList<Integer>> arrayOfMatches = new ArrayList<ArrayList<Integer>>(); //Declares empty Hashmap of Hashmaps to return at the end
        int whichPDF = 0;
        int whichOtherPDF = 0;

        for(HashMap<String, Integer> pdf : pdfList){ //Iterates through ArrayList of Hashmaps
            whichPDF++;
            for (Map.Entry<String, Integer> wordEntry : pdf.entrySet()) { //Iterates through each Hashmap within the ArrayList
                String word = wordEntry.getKey();
                int wordAppearances = wordEntry.getValue();
                int matches;
                for(HashMap<String, Integer> otherPDF : pdfList){
                    for (Map.Entry<String, Integer> sameWordInOtherPDF : otherPDF.entrySet()) { //Iterates through each Hashmap within the ArrayList
                        if (otherPDF.containsKey(word)) { //Checks all of the other PDFs for the same word
                            if (sameWordInOtherPDF.getValue() < wordAppearances) {
                                matches = sameWordInOtherPDF.getValue();
                            } else{
                                matches = wordAppearances;
                            }
                        }
                    }
                }
            }
        }

        return arrayOfMatches;
    }
}
