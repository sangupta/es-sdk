package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexedDocument;

public class SearchHits {

	@SerializedName("total")
	private long total;
	
	@SerializedName("max_score")
	private double maxScore;
	
	@SerializedName("hits")
	private IndexedDocument[] documents;
	
	// Usual accessors follow

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the maxScore
	 */
	public double getMaxScore() {
		return maxScore;
	}

	/**
	 * @param maxScore the maxScore to set
	 */
	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	/**
	 * @return the documents
	 */
	public IndexedDocument[] getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(IndexedDocument[] documents) {
		this.documents = documents;
	}
	
}
