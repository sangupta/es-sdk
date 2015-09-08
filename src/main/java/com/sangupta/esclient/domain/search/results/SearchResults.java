package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;

public class SearchResults {
	
	@SerializedName("took")
	private long took;
	
	@SerializedName("timedOut")
	private boolean timedOut;
	
	@SerializedName("_shards")
	private ShardInfo shards;
	
	@SerializedName("hits")
	private SearchHits hits;
	
	@Override
	public String toString() {
		return "[SearchResults: hits=" + this.hits.getTotal() + ", time=" + this.took + "]";
	}
	
	// Usual accessors follow

	/**
	 * @return the took
	 */
	public long getTook() {
		return took;
	}

	/**
	 * @param took the took to set
	 */
	public void setTook(long took) {
		this.took = took;
	}

	/**
	 * @return the timedOut
	 */
	public boolean isTimedOut() {
		return timedOut;
	}

	/**
	 * @param timedOut the timedOut to set
	 */
	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	/**
	 * @return the shards
	 */
	public ShardInfo getShards() {
		return shards;
	}

	/**
	 * @param shards the shards to set
	 */
	public void setShards(ShardInfo shards) {
		this.shards = shards;
	}

	/**
	 * @return the hits
	 */
	public SearchHits getHits() {
		return hits;
	}

	/**
	 * @param hits the hits to set
	 */
	public void setHits(SearchHits hits) {
		this.hits = hits;
	}

}
