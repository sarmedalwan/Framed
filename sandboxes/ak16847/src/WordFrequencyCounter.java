import java.util.*;

public class WordFrequencyCounter {
    private List<HashMap<String,Integer>> listOfMaps;
    private List<String> ignoreList;

    public WordFrequencyCounter(){
        listOfMaps=new ArrayList<>();
        ignoreList = new ArrayList<>();
    }

    public void addIgnoredWord(ArrayList<String> words){
        ignoreList.addAll(words);
    }

    public void addIgnoredWord(String word){
        ignoreList.add(word);

    }

    public void clearIgnoredWords(){
        ignoreList.clear();
    }

    public void addArray(ArrayList<String> pdfArray){
        HashMap<String,Integer> map = new HashMap<>();
        for (String word:pdfArray){
            if (!ignoreList.contains(word)){
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                }
                else {
                    int count= map.get(word)+1;
                    map.replace(word,count);
                }
            }
        }
        listOfMaps.add(map);
    }
    public Map<String,Integer>[] getArray(){

        return listOfMaps.toArray(new Map[listOfMaps.size()]);
    }
    public List<String> getIgnoreList(){
        return ignoreList;
    }
}
