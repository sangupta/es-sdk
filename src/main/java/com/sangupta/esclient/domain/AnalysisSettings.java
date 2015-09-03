package com.sangupta.esclient.domain;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.analysis.CustomAnalyzer;
import com.sangupta.esclient.domain.analysis.CharFilter;

public class AnalysisSettings {
	
	@SerializedName("char_filter")
	private final Map<String, CharFilter> charFilter = new HashMap<>();
	
	private final Map<String, CustomAnalyzer> analyzer = new HashMap<>();
	
	public void addAnalyzer(String name, CustomAnalyzer analyzer) {
		this.analyzer.put(name, analyzer);
	}

	public void addCharFilter(String name, CharFilter charFilter) {
		this.charFilter.put(name, charFilter);
	}
}
