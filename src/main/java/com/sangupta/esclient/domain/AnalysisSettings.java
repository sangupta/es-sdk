package com.sangupta.esclient.domain;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.analysis.AnalyzerFilter;
import com.sangupta.esclient.domain.analysis.CharFilter;
import com.sangupta.esclient.domain.analysis.CustomAnalyzer;

public class AnalysisSettings {
	
	@SerializedName("char_filter")
	private final Map<String, CharFilter> charFilter = new HashMap<>();
	
	@SerializedName("filter")
	private final Map<String, AnalyzerFilter> filters = new HashMap<>();
	
	@SerializedName("analyzer")
	private final Map<String, CustomAnalyzer> analyzer = new HashMap<>();
	
	public void addAnalyzer(String name, CustomAnalyzer analyzer) {
		this.analyzer.put(name, analyzer);
	}

	public void addCharFilter(String name, CharFilter charFilter) {
		this.charFilter.put(name, charFilter);
	}
	
	public void addAnalyzerFilter(String name, AnalyzerFilter filter) {
		this.filters.put(name, filter);
	}
}
