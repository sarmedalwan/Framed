package CE320;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class SortAlgorithm {

	public static void main(String[] args) {
		
		System.out.print("hello,Peng!\n");
		//data test
		HashMap<String, Integer> word1=new HashMap<String, Integer>();
		word1.put("apple", 10);
		word1.put("orange", 12);
		word1.put("tiger", 32);
		word1.put("pipe", 3);
		PDF pdf1=new PDF(" pdf1 ",word1);
		HashMap<String, Integer> word2=new HashMap<String, Integer>();
		word2.put("apple", 32);
		word2.put("orange", 4);
		word2.put("sticker", 3);
		PDF pdf2=new PDF(" pdf2 ",word2);
		HashMap<String, Integer> word3=new HashMap<String, Integer>();
		word3.put("apple", 65);
		word3.put("gary", 10);
		word3.put("pipe", 23);
		PDF pdf3=new PDF(" pdf3 ",word3);
		HashMap<String, Integer> word4=new HashMap<String, Integer>();
		word4.put("peng", 10);
		word4.put("orange", 33);
		PDF pdf4=new PDF(" pdf4 ",word4);
		HashMap<String, Integer> word5=new HashMap<String, Integer>();
		word5.put("gary", 10);
		word5.put("stiker", 19);
		word5.put("happy", 32);
		word5.put("worry",11);
		PDF pdf5=new PDF(" pdf5 ",word5);
				
		PDF [] pdfs=new PDF[] {pdf1,pdf2,pdf3,pdf4,pdf5};

		ArrayList<SimilarPDF>  similar=SortBubble(pdfs);
		ArrayList<SimilarPDF> result=sortAcorSimilar(similar);
		ArrayList<SimilarPDF>  newResult=NewBean(result);
		
		for(int i=0;i<newResult.size();++i)
		{
		System.out.println("remove repeat element array:Similarity from high to low "+newResult.get(i).pdf1.name+"::"+newResult.get(i).pdf2.name+"array size:"+newResult.get(i).similarValue);
		}
	
		System.out.println("Test Similarity "+GetSimilarity(word1, word2));
		
	}
	// remove the repeated bean
		public  static ArrayList<SimilarPDF>  NewBean(ArrayList<SimilarPDF>  array)
		{
			for (int i = 0; i < array.size()-1; i++) {
	            for (int j = array.size()-1; j > i; j--) {
	                if (array.get(j).pdf1 == array.get(i).pdf1 &&array.get(j).pdf2 == array.get(i).pdf2 &&array.get(j).similarValue == array.get(i).similarValue ) {
	                	array.remove(j);
	                }
	            }
	        }				
			return  array;
	 	}
	//Computing the similarity 
	public static int GetSimilarity(HashMap<String, Integer> map1, HashMap<String, Integer> map2) 
	{
		int result=0;
		if (map1 != null && map2 != null) {
			//System.out.print("Got in\n");
			Iterator iter = map1.entrySet().iterator();
			while (iter.hasNext()) {
			Map.Entry entry1 = (Map.Entry) iter.next();
			Object key = entry1.getKey();
			Object val = entry1.getValue();
			//System.out.print(key.toString()+val+"\n");
			if(map2.containsKey(key)) {
				int temp = Math.min((int)val,map2.get(key));    
				int distance=  Math.max((int)val,map2.get(key))-temp;
				result+=temp-distance;
			//	System.out.print(temp+":"+distance+":"+result+"\n");
			}else
			{
				result-=(int)val;
			}			
			}
			for (Entry<String, Integer> entry2 : map2.entrySet())
			{				
			if(!map1.containsKey(entry2.getKey())) 
			{
					result-=entry2.getValue();	
				}
			}
		}
		return result;
	}
	//List pdf document order by similarity
	public static  ArrayList<SimilarPDF> sortAcorSimilar(ArrayList<SimilarPDF> array)
	{
		   System.out.println("before pdf document been ordered : Data size "+array.size());
	        for (SimilarPDF similarPDF : array) {
	            System.out.println(" PDF document"+similarPDF.pdf1.name+" and "+similarPDF.pdf2.name+" similarValue "+similarPDF.similarValue);
	        }
 Collections.sort(array,new Comparator<SimilarPDF>()
 {
	 
	 @Override
	public int compare(SimilarPDF o1, SimilarPDF o2) {
		// TODO Auto-generated method stub
		return o2.similarValue-o1.similarValue;
	}
});
 System.out.println("After pdf document been ordered: ");
 for (SimilarPDF similarPDF : array) {
     System.out.println("PDF document  "+similarPDF.pdf1.name+" and "+similarPDF.pdf2.name+" similarValue "+similarPDF.similarValue);
 }
		return array;
		 
	}
	//reversal bubble sort
	public static ArrayList<SimilarPDF> SortBubble(PDF[] pdfs){
		ArrayList<SimilarPDF>  similar=new ArrayList<SimilarPDF>();
		 if(pdfs==null||pdfs.length==0){  
	            return null;  
	        }  
		 	PDF pdf =null;  
		 
		 	for (int i = 0; i < pdfs.length-1; i++) {
	            for (int j = pdfs.length-1; j > i; j--) {
				SimilarPDF similarPDF=new SimilarPDF(pdfs[j],pdfs[i],GetSimilarity(pdfs[j].words, pdfs[i].words));
				//if(similar)
				similar.add(similarPDF);			
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		return similar;
	}
}

