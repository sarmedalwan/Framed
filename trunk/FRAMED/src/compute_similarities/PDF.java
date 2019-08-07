package compute_similarities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PDF {
	public static final int ICON_WIDTH = 80;
	public static final int ICON_HEIGHT = 60;

  	public String name;

	private ArrayList<String> words;
	private ArrayList<String> nonIgnoredWords;
  	public HashMap<String, Integer> wordFrequencies;
  	public HashMap<String, Double> similarities;

  	private Point position = new Point(200,200);;
  	private BufferedImage icon;
  	private String path;
  	public float speed;

	public PDF(String name, HashMap<String, Integer> wordFrequencies, HashMap<String, Double> similarities) {
		super();
		this.name = name;
		this.wordFrequencies = wordFrequencies;
		this.similarities = similarities;
		speed=10;
	}

	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(position.x, position.y, ICON_WIDTH, ICON_HEIGHT);

		FontMetrics fm = g.getFontMetrics();
		int w = fm.stringWidth(name);
		int h = fm.getAscent();
		g.setColor(Color.black);
		g.drawString(name, position.x, position.y+(ICON_HEIGHT/2));
	}

	public PDF() {
		super();
		similarities = new HashMap<>();
		wordFrequencies = new HashMap<>();
		words = new ArrayList<>();
		nonIgnoredWords = new ArrayList<>();
		position.translate((int) ((Math.random()*100.0)-50.0),(int) ((Math.random()*100.0)-50.0));
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getWordFrequencies() {
		return wordFrequencies;
	}
	public void setWordFrequencies(HashMap<String, Integer> wordFrequencies) {
		this.wordFrequencies = wordFrequencies;
	}
	public HashMap<String, Double> getSimilarities(){
		return similarities;
	}

	public void setIcon(BufferedImage icon){
		this.icon = icon;
	}
	public BufferedImage getIcon(){
		return this.icon;
	}

	public void setPosition(Point point){
		this.position = point;
	}
	public Point getPosition(){
		return this.position;
	}

	public void setPath(String path){
		this.path = path;
	}
	public String getPath(){
		return this.path;
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getNonIgnoredWords() {
		return nonIgnoredWords;
	}

	public void setNonIgnoredWords(ArrayList<String> nonIgnoredWords) {
		this.nonIgnoredWords = nonIgnoredWords;
	}

	public void addNonIgnoredWord(String word){
		this.nonIgnoredWords.add(word);
	}
}
