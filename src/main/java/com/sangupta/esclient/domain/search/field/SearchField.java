package com.sangupta.esclient.domain.search.field;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.search.SearchOperator;
import com.sangupta.esclient.domain.search.ZeroTermsQuery;
import com.sangupta.esclient.domain.search.query.MatchQueryType;

public class SearchField {
	
	@SerializedName("query")
	protected String query;
	
	@SerializedName("operator")
	protected SearchOperator operator;
	
	@SerializedName("zero_terms_query")
	protected ZeroTermsQuery zeroTermsQuery;
	
	@SerializedName("cutoff_frequency")
	protected Float cutOffFrequency;
	
	@SerializedName("type")
	protected MatchQueryType type;
	
	@SerializedName("analyzer")
	protected String analyzer;
	
	@SerializedName("max_expansions")
	protected Integer maxExpansions;
	
	@SerializedName("minimum_should_match")
	protected String minimumShouldMatch;

	public SearchField(String query) {
		this.query = query;
	}
	
	public SearchField(String query, SearchOperator operator) {
		this(query);
		this.operator = operator;
	}
	
	// Usual accessors follow

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the operator
	 */
	public SearchOperator getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(SearchOperator operator) {
		this.operator = operator;
	}

	/**
	 * @return the zeroTermsQuery
	 */
	public ZeroTermsQuery getZeroTermsQuery() {
		return zeroTermsQuery;
	}

	/**
	 * @param zeroTermsQuery the zeroTermsQuery to set
	 */
	public void setZeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
		this.zeroTermsQuery = zeroTermsQuery;
	}

	/**
	 * @return the cutOffFrequency
	 */
	public Float getCutOffFrequency() {
		return cutOffFrequency;
	}

	/**
	 * @param cutOffFrequency the cutOffFrequency to set
	 */
	public void setCutOffFrequency(Float cutOffFrequency) {
		this.cutOffFrequency = cutOffFrequency;
	}

	/**
	 * @return the type
	 */
	public MatchQueryType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(MatchQueryType type) {
		this.type = type;
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
	 * @return the maxExpansions
	 */
	public Integer getMaxExpansions() {
		return maxExpansions;
	}

	/**
	 * @param maxExpansions the maxExpansions to set
	 */
	public void setMaxExpansions(Integer maxExpansions) {
		this.maxExpansions = maxExpansions;
	}

	/**
	 * @return the minimumShouldMatch
	 */
	public String getMinimumShouldMatch() {
		return minimumShouldMatch;
	}

	/**
	 * @param minimumShouldMatch the minimumShouldMatch to set
	 */
	public void setMinimumShouldMatch(String minimumShouldMatch) {
		this.minimumShouldMatch = minimumShouldMatch;
	}
}
