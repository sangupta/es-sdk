package com.sangupta.esclient;

import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;

public interface ElasticSearchClient {
	
	/**
	 * Create a new index in ElasticSearch.
	 * 
	 * @param name
	 *            the name of the index
	 * 
	 * @param settings
	 *            the {@link IndexSettings}
	 * 
	 * @param mappings
	 *            the {@link IndexMapping}s that should be added to this index
	 */
	public void createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings);
	
	/**
	 * Add the document to the ElasticSearch index.
	 * 
	 * @param index
	 *            the name of the index
	 * 
	 * @param mapping
	 *            the name of the mapping
	 * 
	 * @param documentID
	 *            the unique ID for the document
	 * 
	 * @param document
	 *            the document object. The object is converted to JSON using
	 *            Google GSON library
	 */
	public void indexDocument(String index, String mapping, String documentID, Object document);
	
}
