package com.sangupta.esclient.domain;

public class IndexSettings {
	
	private int numberOfShards = 1;
	
	private int numberOfReplicas = 1;
	
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
