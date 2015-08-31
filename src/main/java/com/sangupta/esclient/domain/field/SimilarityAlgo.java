package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;

public enum SimilarityAlgo {
	
	@SerializedName("default")
	Default_TF_IDF,
	
	@SerializedName("BM25")
	BM25;

}
