package com.sangupta.esclient.domain.analysis;

import com.google.gson.annotations.SerializedName;

public abstract class AnalyzerFilter {

	@SerializedName("type")
	protected String type;
	
	public AnalyzerFilter(String type) {
		this.type = type;
	}
}
