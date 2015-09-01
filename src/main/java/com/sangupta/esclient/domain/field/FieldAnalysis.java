package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;

public enum FieldAnalysis {

	@SerializedName("analyzed")
	Analyzed,
	
	@SerializedName("not_analyzed")
	NotAnalyzed,
	
	@SerializedName("no")
	No;
	
}
