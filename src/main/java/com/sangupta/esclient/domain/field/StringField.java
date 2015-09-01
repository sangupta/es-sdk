package com.sangupta.esclient.domain.field;

import com.sangupta.esclient.domain.IndexField;

public class StringField extends IndexField {

	protected TermVector termVector;
	
	protected String analyzer;
	
	protected String indexAnalyzer;
	
	protected String searchAnalyzer;

	protected Integer ignoreAbove;
	
	protected Integer positionOffsetGap;
	
	protected Norms norms;
	
	public StringField() {
		super(FieldType.String);
	}
	
	public StringField(FieldAnalysis analysis) {
		this();
		this.index = analysis;
	}
	
	// Usual acessors follow

	/**
	 * @return the termVector
	 */
	public TermVector getTermVector() {
		return termVector;
	}

	/**
	 * @param termVector the termVector to set
	 */
	public void setTermVector(TermVector termVector) {
		this.termVector = termVector;
	}

	/**
	 * @return the analyzer
	 */
	public String getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * @return the indexAnalyzer
	 */
	public String getIndexAnalyzer() {
		return indexAnalyzer;
	}

	/**
	 * @param indexAnalyzer the indexAnalyzer to set
	 */
	public void setIndexAnalyzer(String indexAnalyzer) {
		this.indexAnalyzer = indexAnalyzer;
	}

	/**
	 * @return the searchAnalyzer
	 */
	public String getSearchAnalyzer() {
		return searchAnalyzer;
	}

	/**
	 * @param searchAnalyzer the searchAnalyzer to set
	 */
	public void setSearchAnalyzer(String searchAnalyzer) {
		this.searchAnalyzer = searchAnalyzer;
	}

	/**
	 * @return the ignoreAbove
	 */
	public int getIgnoreAbove() {
		return ignoreAbove;
	}

	/**
	 * @param ignoreAbove the ignoreAbove to set
	 */
	public void setIgnoreAbove(int ignoreAbove) {
		this.ignoreAbove = ignoreAbove;
	}

	/**
	 * @return the positionOffsetGap
	 */
	public int getPositionOffsetGap() {
		return positionOffsetGap;
	}

	/**
	 * @param positionOffsetGap the positionOffsetGap to set
	 */
	public void setPositionOffsetGap(int positionOffsetGap) {
		this.positionOffsetGap = positionOffsetGap;
	}

	/**
	 * @return the norms
	 */
	public Norms getNorms() {
		return norms;
	}

	/**
	 * @param norms the norms to set
	 */
	public void setNorms(Norms norms) {
		this.norms = norms;
	}
	
}
