package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;

public class ShardInfo {

	@SerializedName("total")
	private long total;
	
	@SerializedName("successful")
	private long successful;
	
	@SerializedName("failed")
	private long failed;
	
}
