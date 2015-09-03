package com.sangupta.esclient.domain.search.results;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexedDocument;

public class SearchHits {

	@SerializedName("total")
	private long total;
	
	@SerializedName("max_score")
	private double maxScore;
	
	@SerializedName("hits")
	private IndexedDocument[] documents;
	
}
