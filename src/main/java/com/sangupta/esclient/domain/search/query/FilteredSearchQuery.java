package com.sangupta.esclient.domain.search.query;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.search.filter.SearchFilter;

public class FilteredSearchQuery implements SearchQuery {

	@SerializedName("filtered")
	private final Map<String, Object> filtered = new HashMap<>();
	
	public FilteredSearchQuery(SearchFilter filter) {
		this.filtered.put("filter", filter);
	}

	public FilteredSearchQuery(SearchQuery query, SearchFilter filter) {
		this(filter);
		this.filtered.put("query", query);
	}
}
