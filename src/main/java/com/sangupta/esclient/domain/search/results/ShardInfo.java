package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;

public class ShardInfo {

	@SerializedName("total")
	private long total;
	
	@SerializedName("successful")
	private long successful;
	
	@SerializedName("failed")
	private long failed;
	
	// Usual accessors follow

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the successful
	 */
	public long getSuccessful() {
		return successful;
	}

	/**
	 * @param successful the successful to set
	 */
	public void setSuccessful(long successful) {
		this.successful = successful;
	}

	/**
	 * @return the failed
	 */
	public long getFailed() {
		return failed;
	}

	/**
	 * @param failed the failed to set
	 */
	public void setFailed(long failed) {
		this.failed = failed;
	}
	
}
