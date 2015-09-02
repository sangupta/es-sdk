package com.sangupta.esclient;

import java.util.Map;

import com.sangupta.esclient.domain.IndexDetails;
import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexResult;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.domain.IndexedDocument;
import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.SearchResults;
import com.sangupta.esclient.exception.IndexAlreadyExistsException;
import com.sangupta.esclient.intercept.DocumentIndexInterceptor;

/**
 * Contract for all clients that are available.
 * 
 * @author sangupta
 *
 */
public interface ElasticSearchClient {
	
	// Interceptors
	
	public void addDocumentIndexInterceptor(DocumentIndexInterceptor<? extends Object> interceptor);
	
	// Indices API - https://www.elastic.co/guide/en/elasticsearch/reference/current/indices.html
	
	public IndexResult createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings) throws IndexAlreadyExistsException;
	
	public IndexDetails getIndex(String indexName);

	public boolean existsIndex(String indexName);
	
	public boolean deleteIndex(String indexName);
	
	public boolean closeIndex(String indexName);
	
	public boolean openIndex(String indexName);
	
	// Document API - https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html
	
	public IndexResult indexDocument(String index, String mapping, String documentID, Object document);
	
	public boolean existsDocument(String indexName, String mapping, String documentID);
	
	public IndexedDocument getDocument(String indexName, String mapping, String documentID);
	
	public <T> T getDocument(String indexName, String mapping, String documentID, Class<T> classOfT);
	
	public IndexedDocument deleteDocument(String indexName, String mapping, String documentID);
	
	public boolean updateDocument(String indexName, String mapping, String documentID, Object document);
	
	// Search API - https://www.elastic.co/guide/en/elasticsearch/reference/current/search.html
	
	public SearchResults search(String indexName, String mapping, SearchQuery query);
	
	// CAT API - https://www.elastic.co/guide/en/elasticsearch/reference/current/cat.html
	
}
