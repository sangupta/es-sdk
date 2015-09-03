package com.sangupta.esclient.domain;

import com.sangupta.esclient.domain.analysis.CustomAnalyzer;
import com.sangupta.esclient.domain.analysis.CharFilter;

public class IndexSettings {
	
	private int numberOfShards = 1;
	
	private int numberOfReplicas = 1;
	
	private AnalysisSettings analysis;
	
	public void addAnalyzer(String name, CustomAnalyzer analyzer) {
		if(this.analysis == null) {
			this.analysis = new AnalysisSettings();
		}
		
		this.analysis.addAnalyzer(name, analyzer);
	}
	
	public void addCharFilter(String name, CharFilter charFilter) {
		if(this.analysis == null) {
			this.analysis = new AnalysisSettings();
		}
		
		this.analysis.addCharFilter(name, charFilter);
	}
	
	// Usual accessors follow

	/**
	 * @return the numberOfShards
	 */
	public int getNumberOfShards() {
		return numberOfShards;
	}

	/**
	 * @param numberOfShards the numberOfShards to set
	 */
	public void setNumberOfShards(int numberOfShards) {
		this.numberOfShards = numberOfShards;
	}

	/**
	 * @return the numberOfReplicas
	 */
	public int getNumberOfReplicas() {
		return numberOfReplicas;
	}

	/**
	 * @param numberOfReplicas the numberOfReplicas to set
	 */
	public void setNumberOfReplicas(int numberOfReplicas) {
		this.numberOfReplicas = numberOfReplicas;
	}

}
