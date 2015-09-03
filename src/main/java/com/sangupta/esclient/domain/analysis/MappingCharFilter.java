package com.sangupta.esclient.domain.analysis;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MappingCharFilter extends CharFilter {
	
	@SerializedName("mappings")
	private final List<String> mappings = new ArrayList<>();

	public MappingCharFilter() {
		super("mapping");
	}

	public void addCharMapping(String fromToken, String toToken) {
		this.mappings.add(fromToken + "=>" + toToken);
	}
	
}
