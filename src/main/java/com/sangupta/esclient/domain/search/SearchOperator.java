package com.sangupta.esclient.domain.search;

import com.google.gson.annotations.SerializedName;

public enum SearchOperator {

	@SerializedName("and")
	AND,
	
	@SerializedName("or")
	OR;
	
	
}
