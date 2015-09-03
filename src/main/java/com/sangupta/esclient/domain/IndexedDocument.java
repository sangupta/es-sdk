package com.sangupta.esclient.domain;

import com.google.gson.annotations.SerializedName;

public class IndexedDocument {
	
	@SerializedName("_index")
	private String index;
	
	@SerializedName("_type")
	private String type;
	
	@SerializedName("_id")
	private String id;
	
	@SerializedName("_version")
	private long version;
	
	@SerializedName("found")
	private boolean found;
	
	@SerializedName("score")
	private double score;
	
	@SerializedName("_source")
	private Object source;
	
}
