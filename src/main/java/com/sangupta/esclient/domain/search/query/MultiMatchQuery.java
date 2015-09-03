package com.sangupta.esclient.domain.search.query;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.search.field.SearchField;

public class MultiMatchQuery implements SearchQuery {

	@SerializedName("multi_match")
	protected final Map<String, SearchField> multiMatch = new HashMap<>();
	
	public MultiMatchQuery(String fieldName, SearchField field) {
		this.multiMatch.put(fieldName, field);
	}
	
}
