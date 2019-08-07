package CE320;

import java.util.ArrayList;
import java.util.HashMap;

public class PDF {
  public String name;
//  public String word;
//  public int frequency;
  public HashMap<String, Integer> words;
  public PDF(String name, String word, int frequency) {
		super();
		this.name = name;
		
		
	}
	public PDF(String name, HashMap<String, Integer> words) {
	super();
	this.name = name;
	this.words = words;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	

	public PDF() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getWords() {
		return words;
	}
	public void setWords(HashMap<String, Integer> words) {
		this.words = words;
	}


}
