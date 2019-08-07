package word_pdf_frequency;

import compute_similarities.PDF;
import csv_ignored_words_reader.IgnoredWordsCsvReader;

import java.util.*;

public class WordFrequencyCounter {
    private List<HashMap<String, Integer>> listOfMaps;
    private List<String> ignoreList;


    public WordFrequencyCounter() {
        listOfMaps = new ArrayList<>();
        ignoreList = new ArrayList<>();
    }

    public void addIgnoredWords(ArrayList<String> words) {
        ignoreList.addAll(words);
    }

    public void addIgnoredWords(String word) {
        ignoreList.add(word);
    }

    public void clearIgnoredWords() {
        ignoreList.clear();
    }


    public HashMap<String, Integer>[] getAllPdfCounterArray() {

        return listOfMaps.toArray(new HashMap[listOfMaps.size()]);
    }

    public List<String> getIgnoreList() {
        return ignoreList;
    }

    public HashMap<String, Integer> calculateFrequenciesForPdf(PDF pdf){
        HashMap<String, Integer> wordCountsMap = new HashMap<>();

        for (String eachWord : pdf.getWords()) {
            if (!ignoreList.contains(eachWord)) {
                if (!wordCountsMap.containsKey(eachWord)) {
                    wordCountsMap.put(eachWord, 1);
                } else {
                    int count = wordCountsMap.get(eachWord) + 1;
                    wordCountsMap.replace(eachWord, count);
                }
                pdf.addNonIgnoredWord(eachWord);
            }
        }

        return wordCountsMap;
    }

    public void calculateFrequenciesForMultiplePdfs(ArrayList<PDF> pdfs, String ignoredWordsPath) {
        if(ignoredWordsPath != null && !ignoredWordsPath.isEmpty()) {
            addIgnoredWords(IgnoredWordsCsvReader.readCsvFile(ignoredWordsPath));
        }
        for (PDF pdf : pdfs) {
            HashMap<String, Integer> frequencies = calculateFrequenciesForPdf(pdf);
            pdf.setWordFrequencies(frequencies);
        }

    }

}
