package computesimilarities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SortListOfPDFsAndCalculateSimilarities {

	public static void main(String[] args) {
		
		System.out.print("Hello,Peng!\n"); //TESTING
		HashMap<String, Integer> wordsIn1stDocument=new HashMap<String, Integer>(); //Create Hashmap to represent all of the words in the PDF and their frequencies
		wordsIn1stDocument.put("apple", 10);
		wordsIn1stDocument.put("orange", 12);
		wordsIn1stDocument.put("tiger", 32);
		wordsIn1stDocument.put("pipe", 3);
		PDF pdf1=new PDF("PDF1 ",wordsIn1stDocument); //Create PDF object for testing, give it a name and the Hashmap of words

		HashMap<String, Integer> wordsin2ndDocument=new HashMap<String, Integer>();
		wordsin2ndDocument.put("apple", 32);
		wordsin2ndDocument.put("orange", 4);
		wordsin2ndDocument.put("sticker", 3);
		PDF pdf2=new PDF("PDF2 ",wordsin2ndDocument);

		HashMap<String, Integer> wordsin3rdDocument=new HashMap<String, Integer>();
		wordsin3rdDocument.put("apple", 65);
		wordsin3rdDocument.put("gary", 10);
		wordsin3rdDocument.put("pipe", 23);
		PDF pdf3=new PDF("PDF3 ",wordsin3rdDocument);

		HashMap<String, Integer> wordsin4thDocument=new HashMap<String, Integer>();
		wordsin4thDocument.put("peng", 10);
		wordsin4thDocument.put("orange", 33);
		PDF pdf4=new PDF("PDF4 ",wordsin4thDocument);

		HashMap<String, Integer> wordsin5thDocument=new HashMap<String, Integer>();
		wordsin5thDocument.put("gary", 10);
		wordsin5thDocument.put("stiker", 19);
		wordsin5thDocument.put("happy", 32);
		wordsin5thDocument.put("worry",11);
		PDF pdf5=new PDF("PDF5 ",wordsin5thDocument);
				
		PDF[] listOfPDFs=new PDF[] {pdf1,pdf2,pdf3,pdf4,pdf5};

		ArrayList<SimilarityBetweenPDFs> similar= BubbleSort(listOfPDFs);
		ArrayList<SimilarityBetweenPDFs> result= ListSimilarityOf2PDFs(similar);
		ArrayList<SimilarityBetweenPDFs> newResult= RemoveRepeatedMatches(result);
		
		for(int i=0;i<newResult.size();++i) {
			System.out.println("Removed repeated element array: Similarity from high to low "+newResult.get(i).pdf1.name+": "+newResult.get(i).pdf2.name+"array size:"+newResult.get(i).similarityValue);
		}

		System.out.println("Test Similarity "+GetSimilarity(wordsIn1stDocument, wordsin2ndDocument));
	}

	public  static ArrayList<SimilarityBetweenPDFs> RemoveRepeatedMatches(ArrayList<SimilarityBetweenPDFs>  array) {
		for (int i = 0; i < array.size()-1; i++) {
			for (int j = array.size()-1; j > i; j--) {
				if (array.get(j).pdf1 == array.get(i).pdf1 &&array.get(j).pdf2 == array.get(i).pdf2 &&array.get(j).similarityValue == array.get(i).similarityValue) {
					array.remove(j);
				}
			}
		}
		return array;
	}

	public static int GetSimilarity(HashMap<String, Integer> FirstPDFsWords, HashMap<String, Integer> SecondPDFsWords) {
		int result=0;
		if (FirstPDFsWords != null && SecondPDFsWords != null) {
			Iterator iterator = FirstPDFsWords.entrySet().iterator();
			while (iterator.hasNext()) {
			Map.Entry wordEntry1 = (Map.Entry) iterator.next();
			Object word = wordEntry1.getKey();
			Object frequency = wordEntry1.getValue();
			if(SecondPDFsWords.containsKey(word)) {
				int temp = Math.min((int)frequency,SecondPDFsWords.get(word));
				int distance=  Math.max((int)frequency,SecondPDFsWords.get(word))-temp;
				result+=temp-distance;
			}else {
				result-=(int)frequency;
			}
			}
			for (Entry<String, Integer> wordEntry2 : SecondPDFsWords.entrySet())
			{
				if(!FirstPDFsWords.containsKey(wordEntry2.getKey())) {
						result-=wordEntry2.getValue();
				}
			}
		}
		return result;
	}

	//List PDF documents ordered by similarity
	public static  ArrayList<SimilarityBetweenPDFs> ListSimilarityOf2PDFs(ArrayList<SimilarityBetweenPDFs> array) {
		System.out.println("Before PDF document been ordered: Data size "+array.size());
		for (SimilarityBetweenPDFs similarityBetweenPDFs : array) {
			System.out.println(" PDF document"+ similarityBetweenPDFs.pdf1.name+" and "+ similarityBetweenPDFs.pdf2.name+" similarityValue "+ similarityBetweenPDFs.similarityValue);
		}
		Collections.sort(array,new Comparator<SimilarityBetweenPDFs>() {
			@Override
			public int compare(SimilarityBetweenPDFs o1, SimilarityBetweenPDFs o2) {
				return o2.similarityValue -o1.similarityValue;
			}
		});
		System.out.println("After PDF documents have been ordered: ");
		for (SimilarityBetweenPDFs similarityBetweenPDFs : array) {
			System.out.println("PDF document  "+ similarityBetweenPDFs.pdf1.name+" and "+ similarityBetweenPDFs.pdf2.name+" similarityValue "+ similarityBetweenPDFs.similarityValue);
		}
		return array;
	}

	public static ArrayList<SimilarityBetweenPDFs> BubbleSort(PDF[] pdfs){
		ArrayList<SimilarityBetweenPDFs>  similarityBetweenTwoDocuments=new ArrayList<SimilarityBetweenPDFs>();
		if(pdfs==null||pdfs.length==0){
			return null;
		}
		for (int i = 0; i < pdfs.length-1; i++) {
			for (int j = pdfs.length-1; j > i; j--) {
				SimilarityBetweenPDFs similarityBetweenPDFs =new SimilarityBetweenPDFs(pdfs[j],pdfs[i],GetSimilarity(pdfs[j].words, pdfs[i].words));
				similarityBetweenTwoDocuments.add(similarityBetweenPDFs);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		return similarityBetweenTwoDocuments;
	}
}

