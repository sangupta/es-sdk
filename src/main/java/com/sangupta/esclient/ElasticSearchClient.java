package com.sangupta.esclient;

import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;

public interface ElasticSearchClient {
	
	public void createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings);

}
