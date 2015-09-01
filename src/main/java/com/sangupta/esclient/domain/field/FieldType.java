package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;

public enum FieldType {

	@SerializedName("string")
	String,
	
	Date,
	
	Float,
	
	Double,
	
	Byte,
	
	Short,
	
	Integer,
	
	Long,
	
	TokenCount,
	
	Boolean,
	
	Binary;
	
}
