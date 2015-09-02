package com.sangupta.esclient.vo;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;

public class IndexDetails {
	
	@SerializedName("creation_date")
	public long creationDate;

	@SerializedName("settings")
	public IndexSettings settings;

	@SerializedName("mappings")
	public Map<String, IndexMapping> mappings;
	
	public IndexDetails(IndexSettings settings, Map<String, IndexMapping> mappings) {
		this.settings = settings;
		this.mappings = mappings;
	}
	
}
