package com.sangupta.esclient.domain.search;

import com.google.gson.annotations.SerializedName;

public enum SearchType {

	@SerializedName("dfs_query_then_fetch")
	DFS_QUERY_THEN_FETCH,
	
	@SerializedName("dfs_query_and_fetch")
	DFS_QUERY_AND_FETCH,
	
	@SerializedName("query_then_fetch")
	QUERY_THEN_FETCH,
	
	@SerializedName("query_and_fetch")
	QUERY_AND_FETCH;
	
}
