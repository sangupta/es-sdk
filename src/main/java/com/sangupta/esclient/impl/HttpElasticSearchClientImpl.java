package com.sangupta.esclient.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.sangupta.esclient.ElasticSearchClient;
import com.sangupta.esclient.domain.IndexDetails;
import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexResult;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.domain.IndexedDocument;
import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.search.results.SearchResults;
import com.sangupta.esclient.exception.IndexAlreadyExistsException;
import com.sangupta.esclient.intercept.DocumentIndexInterceptor;
import com.sangupta.jerry.constants.HttpMimeType;
import com.sangupta.jerry.exceptions.NotImplementedException;
import com.sangupta.jerry.http.WebInvoker;
import com.sangupta.jerry.http.WebRequest;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;
import com.sangupta.jerry.util.UriUtils;

/**
 * An Apache HTTP Client based implementation of the {@link ElasticSearchClient}.
 * 
 * @author sangupta
 *
 */
public class HttpElasticSearchClientImpl implements ElasticSearchClient {
	
	/**
	 * My instance logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpElasticSearchClientImpl.class);
	
	/**
	 * The elastic search server to use
	 */
	protected final String elasticSearchServer;
	
	/**
	 * Set of {@link DocumentIndexInterceptor}s that are plugged in 
	 */
	protected final List<DocumentIndexInterceptor> indexInterceptors = new ArrayList<>();
	
	/**
	 * Default constructor - must pass an elastic search server
	 * 
	 * @param elasticSearchServer the URL of the ElasticSearch server to use
	 */
	public HttpElasticSearchClientImpl(String elasticSearchServer) {
		this.elasticSearchServer = elasticSearchServer;
	}
	
	/**
	 * Add a new {@link DocumentIndexInterceptor}.
	 * 
	 * @param interceptor the {@link DocumentIndexInterceptor} to add
	 */
	public void addDocumentIndexInterceptor(DocumentIndexInterceptor<? extends Object> interceptor) {
		this.indexInterceptors.add(interceptor);
	}
	
	@Override
	public IndexResult createIndex(String indexName, IndexSettings settings, Map<String, IndexMapping> mappings) throws IndexAlreadyExistsException {
		if(AssertUtils.isEmpty(indexName)) {
			throw new IllegalArgumentException("Index name cannot be empty/null");
		}
		
		if(!indexName.equals(indexName.toLowerCase())) {
			throw new IllegalArgumentException("Index name must be lowercase");
		}
		
		if(settings == null) {
			throw new IllegalArgumentException("IndexSettings cannot be null - use a default instance instead");
		}
		
		if(mappings == null) {
			throw new IllegalArgumentException("IndexMappings cannot be null");
		}
		
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName);
		WebRequest request = WebRequest.post(endPoint);
		String requestBody = GsonUtils.getGson().toJson(new IndexDetails(settings, mappings));
		LOGGER.debug("IndexCreation request as: {}", requestBody);
		request.bodyString(requestBody, HttpMimeType.JSON);
		
		WebResponse response = WebInvoker.executeSilently(request);
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			String apiResponse = response.getContent();
			if(apiResponse.contains("IndexAlreadyExistsException")) {
				throw new IndexAlreadyExistsException();
			}
			
			LOGGER.warn("Non-success response for index creation from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return null;
		}
		
		String apiResponse = response.getContent();
		LOGGER.debug("API response is: {}", apiResponse);
		return null;
	}

	@Override
	public IndexDetails getIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName);
		WebResponse response = WebInvoker.getResponse(endPoint);
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}

		String apiResponse = response.getContent();
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index creation from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return null;
		}
		
		LOGGER.debug("API response is: {}", apiResponse);
		return GsonUtils.getGson().fromJson(apiResponse, IndexDetails.class);
	}
	
	@Override
	public boolean existsIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName);
		WebResponse response = WebInvoker.executeSilently(WebRequest.head(endPoint));
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return false;
		}

		String apiResponse = response.getContent();
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index exists check from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return false;
		}
		
		LOGGER.debug("API response is: {}", apiResponse);
		return true;
	}

	@Override
	public boolean deleteIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName);
		WebResponse response = WebInvoker.executeSilently(WebRequest.delete(endPoint));
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return false;
		}

		String apiResponse = response.getContent();
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index deletion from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return false;
		}
		
		LOGGER.debug("API response is: {}", apiResponse);
		return true;
	}
	
	@Override
	public boolean closeIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, "_close");
		WebResponse response = WebInvoker.executeSilently(WebRequest.post(endPoint));
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return false;
		}

		String apiResponse = response.getContent();
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index closing from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return false;
		}
		
		LOGGER.debug("API response is: {}", apiResponse);
		return true;
	}
	
	@Override
	public boolean openIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, "_open");
		WebResponse response = WebInvoker.executeSilently(WebRequest.post(endPoint));
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return false;
		}

		String apiResponse = response.getContent();
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index opening from elastic search server at {} with response {}", endPoint, response);
			LOGGER.warn("Response is: {}", apiResponse);
			return false;
		}
		
		LOGGER.debug("API response is: {}", apiResponse);
		return true;
	}

	@Override
	public IndexResult indexDocument(String index, String mapping, String documentID, Object document) {
		if(AssertUtils.isEmpty(index)) {
			throw new IllegalArgumentException("Index name cannot be empty/null");
		}
		
		if(!index.equals(index.toLowerCase())) {
			throw new IllegalArgumentException("Index name must be lowercase");
		}
		
		if(AssertUtils.isNotEmpty(this.indexInterceptors)) {
			for(DocumentIndexInterceptor interceptor : this.indexInterceptors) {
				boolean doNotIndex = interceptor.beforeSerialization(document);
				if(doNotIndex) {
					return null;
				}
			}
		}
		
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), index, mapping, documentID);
		WebRequest request = WebRequest.put(endPoint);
		
		String requestBody;
		if(AssertUtils.isEmpty(this.indexInterceptors)) {
			requestBody = GsonUtils.getGson().toJson(document);
		} else {
			JsonElement jsonElement = GsonUtils.getGson().toJsonTree(document);
			for(DocumentIndexInterceptor interceptor : this.indexInterceptors) {
				boolean doNotIndex = interceptor.afterSerialization(jsonElement);
				if(doNotIndex) {
					return null;
				}
			}
			
			requestBody = GsonUtils.getGson().toJson(jsonElement);
		}
		
		LOGGER.debug("DocumentIndex request as: {}", requestBody);
		request.bodyString(requestBody, HttpMimeType.JSON, "UTF-8");
		
		WebResponse response = WebInvoker.executeSilently(request);
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for document index from elastic search server at {}", endPoint);
			return null;
		}
		
		return GsonUtils.getGson().fromJson(response.getContent(), IndexResult.class);
	}
	
	@Override
	public boolean existsDocument(String indexName, String mapping, String documentID) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, mapping, documentID);
		WebResponse response = WebInvoker.executeSilently(WebRequest.head(endPoint));

		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return false;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for get document from elastic search server at {}", endPoint);
			return false;
		}
		
		return true;
	}

	@Override
	public IndexedDocument getDocument(String indexName, String mapping, String documentID) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, mapping, documentID);
		WebResponse response = WebInvoker.getResponse(endPoint);

		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for get document from elastic search server at {}", endPoint);
			return null;
		}
		
		String apiResponse = response.getContent();
		return GsonUtils.getGson().fromJson(apiResponse, IndexedDocument.class);
	}
	
	@Override
	public <T> T getDocument(String indexName, String mapping, String documentID, Class<T> classOfT) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, mapping, documentID, "_source");
		WebResponse response = WebInvoker.getResponse(endPoint);

		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for get document from elastic search server at {}", endPoint);
			return null;
		}
		
		String apiResponse = response.getContent();
		return GsonUtils.getGson().fromJson(apiResponse, classOfT);
	}
	
	@Override
	public IndexedDocument deleteDocument(String indexName, String mapping, String documentID) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, mapping, documentID);
		WebResponse response = WebInvoker.executeSilently(WebRequest.delete(endPoint));

		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for get document from elastic search server at {}", endPoint);
			return null;
		}
		
		String apiResponse = response.getContent();
		return GsonUtils.getGson().fromJson(apiResponse, IndexedDocument.class);
	}
	
	@Override
	public boolean updateDocument(String indexName, String mapping, String documentID, Object document) {
		throw new NotImplementedException();
	}
	
	@Override
	public SearchResults search(String indexName, String mapping, SearchQuery query) {
		String endPoint = UriUtils.addWebPaths(this.getElasticSearchServer(), indexName, mapping, "_search");
		
		WebRequest request = WebRequest.post(endPoint);
		String body = "{ \"query\" : " + GsonUtils.getGson().toJson(query) + " }";
		LOGGER.debug("Using search query string as: {}", body);
		request.bodyString(body, HttpMimeType.JSON, "UTF-8");
		WebResponse response = WebInvoker.executeSilently(request);

		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return null;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for get document from elastic search server at {}", endPoint);
			return null;
		}
		
		String apiResponse = response.getContent();
		return GsonUtils.getGson().fromJson(apiResponse, SearchResults.class);
	}
	
	// Abstraction methods
	
	protected String getElasticSearchServer() {
		return this.elasticSearchServer;
	}
	
}
