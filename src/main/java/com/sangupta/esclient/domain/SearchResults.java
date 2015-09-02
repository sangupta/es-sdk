package com.sangupta.esclient.domain;

import com.google.gson.annotations.SerializedName;

public class SearchResults {
	
	@SerializedName("_shards")
	private ShardInfo shards;
	
	@SerializedName("hits")
	private Hits hits;

	
	public static class ShardInfo {
		
		@SerializedName("total")
		private long total;
		
		@SerializedName("successful")
		private long successful;
		
		@SerializedName("failed")
		private long failed;

	}

	public static class Hits {
		
		@SerializedName("total")
		private long total;
		
		@SerializedName("hits")
		private IndexedDocument[] documents;
	}
	
}
