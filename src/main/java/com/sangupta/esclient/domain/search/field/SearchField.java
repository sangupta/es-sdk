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
}
