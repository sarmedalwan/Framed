package computesimilarities;

public class SimilarityBetweenPDFs {
	
	public PDF  pdf1;
	public PDF  pdf2;
	public int similarityValue;
	
	public SimilarityBetweenPDFs(PDF pdf1, PDF pdf2, int similarityValue) {
		super();
		this.pdf1 = pdf1;
		this.pdf2 = pdf2;
		this.similarityValue = similarityValue;
	}

	public SimilarityBetweenPDFs() {
		super();
	}
	
}
