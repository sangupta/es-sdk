package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;

public enum DateUnit {
	
	@SerializedName("seconds")
	Seconds,
	
	@SerializedName("milliseconds")
	MilliSeconds;

}
