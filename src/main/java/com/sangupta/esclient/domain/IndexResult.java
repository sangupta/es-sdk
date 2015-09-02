package com.sangupta.esclient.domain;

import com.google.gson.annotations.SerializedName;

public class IndexResult {

	@SerializedName("_index")
	public String index;
	
	@SerializedName("_type")
	public String type;
	
	@SerializedName("_id")
	public String id;
	
	@SerializedName("_version")
	public long version;
	
	@SerializedName("created")
	public boolean created;
	
}
