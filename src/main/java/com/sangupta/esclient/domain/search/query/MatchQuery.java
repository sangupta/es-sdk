package com.sangupta.esclient.domain.search.query;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.search.field.SearchField;

public class MatchQuery implements SearchQuery {
	
	@SerializedName("match")
	protected final Map<String, SearchField> match = new HashMap<>();

	public MatchQuery(String fieldName, SearchField field) {
		this.match.put(fieldName, field);
	}
	
}
