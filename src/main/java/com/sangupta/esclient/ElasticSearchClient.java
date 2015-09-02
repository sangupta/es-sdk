package com.sangupta.esclient;

import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.exception.IndexAlreadyExistsException;
import com.sangupta.esclient.vo.IndexDetails;
import com.sangupta.esclient.vo.IndexResult;

public interface ElasticSearchClient {
	
	public IndexResult createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings) throws IndexAlreadyExistsException;
	
	public IndexDetails getIndex(String indexName);

	public boolean existsIndex(String indexName);
	
	public boolean deleteIndex(String indexName);
	
	public IndexResult indexDocument(String index, String mapping, String documentID, Object document);
	
}
