package compute_similarities;

public class SimilarityBetweenPDFs {
	
	public PDF  pdf1;
	public PDF  pdf2;
	public double similarityValue;
	
	public SimilarityBetweenPDFs(PDF pdf1, PDF pdf2, double similarityValue) {
		super();
		this.pdf1 = pdf1;
		this.pdf2 = pdf2;
		this.similarityValue = similarityValue;
	}

	public SimilarityBetweenPDFs() {
		super();
	}
	
}
