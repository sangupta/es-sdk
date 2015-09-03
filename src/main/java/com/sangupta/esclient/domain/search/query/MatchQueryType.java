package com.sangupta.esclient.domain.search.query;

import com.google.gson.annotations.SerializedName;

public enum MatchQueryType {
	
	@SerializedName("boolean")
	BOOLEAN,
	
	@SerializedName("phrase")
	MATCH_PHRASE,
	
	@SerializedName("phrase_prefix")
	MATCH_PHRASE_PREFIX;

}
