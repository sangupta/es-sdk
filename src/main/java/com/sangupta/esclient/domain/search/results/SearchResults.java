package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;

public class SearchResults {
	
	@SerializedName("took")
	private long took;
	
	@SerializedName("timedOut")
	private boolean timedOut;
	
	@SerializedName("_shards")
	private ShardInfo shards;
	
	@SerializedName("hits")
	private SearchHits hits;

}
