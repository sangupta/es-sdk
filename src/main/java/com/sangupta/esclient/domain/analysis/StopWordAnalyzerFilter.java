package com.sangupta.esclient.domain.analysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

public class StopWordAnalyzerFilter extends AnalyzerFilter {
	
	private static final String TYPE = "stop";
	
	@SerializedName("stopwords")
	protected Set<String> stopWords = new HashSet<>();

	public StopWordAnalyzerFilter() {
		super(TYPE);
	}

	public void addStopWord(String word) {
		this.stopWords.add(word);
	}
	
	public void addStopWords(String[] words) {
		for(String word : words) {
			this.stopWords.add(word);
		}
	}
	
	public void addStopWords(Collection<String> words) {
		this.stopWords.addAll(stopWords);
	}
	
}
