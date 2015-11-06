package com.sangupta.esclient.domain.search.filter;

import com.google.gson.annotations.SerializedName;

public class InnerRangeFilter<T> {

	@SerializedName("gte")
	private T gte;

	@SerializedName("lte")
	private T lte;

	public T getGte() {
		return gte;
	}

	public void setGte(T gte) {
		this.gte = gte;
	}

	public T getLte() {
		return lte;
	}

	public void setLte(T lte) {
		this.lte = lte;
	}
}
