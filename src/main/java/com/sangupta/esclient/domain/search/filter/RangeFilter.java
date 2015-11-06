package com.sangupta.esclient.domain.search.filter;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class RangeFilter<T> implements SearchFilter {

	@SerializedName("range")
	private final Map<String, InnerRangeFilter<T>> range = new HashMap<>();

	private InnerRangeFilter<T> innerRangeFilter = new InnerRangeFilter<T>();

	public RangeFilter(String fieldName) {
		this.range.put(fieldName, innerRangeFilter);
	}

	public SearchFilter lte(T lessThan) {
		this.innerRangeFilter.setLte(lessThan);
		return this;
	}

	public SearchFilter gte(T greaterThan) {
		this.innerRangeFilter.setGte(greaterThan);
		return this;
	}
}
