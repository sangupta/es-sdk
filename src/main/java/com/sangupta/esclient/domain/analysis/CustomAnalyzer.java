package com.sangupta.esclient.domain.analysis;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CustomAnalyzer {
	
	@SerializedName("type")
	private final String type = "custom";

	@SerializedName("tokenizer")
	private final String tokenizer;
	
	@SerializedName("char_filter")
	private final List<String> charFilters = new ArrayList<>();
	
	@SerializedName("filter")
	private final List<String> filters = new ArrayList<>();
	
	public CustomAnalyzer(String tokenizer, String charFilter, String filter) {
		this.tokenizer = tokenizer;
		this.charFilters.add(charFilter);
	}
	
	public CustomAnalyzer(String tokenizer, String[] charFilters, String[] filters) {
		this.tokenizer = tokenizer;
		
		for(String filter : charFilters) {
			this.charFilters.add(filter);
		}
		
		for(String filter : filters) {
			this.filters.add(filter);
		}
	}
	
}
