package com.sangupta.esclient.domain.field;

public class MultiFieldDetail {
	
	protected FieldType type;
	
	protected FieldAnalysis index;
	
	/**
	 * Default constructor
	 * 
	 */
	public MultiFieldDetail() {
		
	}

	public MultiFieldDetail(FieldType type, FieldAnalysis index) {
		this.type = type;
		this.index = index;
	}
}
