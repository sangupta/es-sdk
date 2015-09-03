package com.sangupta.esclient.domain.search.filter;

import com.google.gson.annotations.SerializedName;

public enum FilterStrategy {

	@SerializedName("leap_frog_query_first")
	LEAP_FROG_QUERY_FIRST,
	
	@SerializedName("leap_frog_filter_first")
	LEAP_FROG_FILTER_FIRST,
	
	@SerializedName("leap_frog")
	LEAP_FROG,
	
	@SerializedName("query_first")
	QUERY_FIRST,
	
	@SerializedName("random_access_always")
	RANDOM_ACCESS_ALWAYS;
	
}
