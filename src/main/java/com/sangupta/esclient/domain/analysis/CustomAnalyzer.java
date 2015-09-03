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
	private final List<String> charFilter = new ArrayList<>();
	
	public CustomAnalyzer(String tokenizer, String charFilter) {
		this.tokenizer = tokenizer;
		this.charFilter.add(charFilter);
	}
	
	public CustomAnalyzer(String tokenizer, String[] charFilters) {
		this.tokenizer = tokenizer;
		for(String filter : charFilters) {
			this.charFilter.add(filter);
		}
	}
	
}
