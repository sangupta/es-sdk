package com.sangupta.esclient.domain.search;

import com.google.gson.annotations.SerializedName;

public enum ZeroTermsQuery {

	@SerializedName("none")
	NONE,
	
	@SerializedName("all")
	ALL;
}
