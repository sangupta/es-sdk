package com.sangupta.esclient.domain.search.filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class TermsFilter implements SearchFilter {

	@SerializedName("terms")
	private final Map<String, List<String>> terms = new HashMap<>();

	public TermsFilter(String fieldName, String[] values) {
		this.terms.put(fieldName, Arrays.asList(values));
	}
	
}
