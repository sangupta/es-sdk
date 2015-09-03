package com.sangupta.esclient.domain.search.field;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.search.SearchOperator;

public class SearchMultiField extends SearchField {
	
	@SerializedName("fields")
	protected final List<String> fields = new ArrayList<>();
	
	public SearchMultiField(String query) {
		super(query);
	}
	
	public SearchMultiField(String query, SearchOperator operator) {
		super(query, operator);
	}
	
	public void addField(String fieldName) {
		this.fields.add(fieldName);
	}

	public void addFieldWithBoost(String fieldName, int boost) {
		this.fields.add(fieldName + "^" + boost);
	}
	
}
