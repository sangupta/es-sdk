package com.sangupta.esclient.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sangupta.esclient.ElasticSearchClient;
import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.exception.IndexAlreadyExistsException;
import com.sangupta.esclient.vo.IndexDetails;
import com.sangupta.esclient.vo.IndexResult;
import com.sangupta.jerry.constants.HttpMimeType;
import com.sangupta.jerry.http.WebInvoker;
import com.sangupta.jerry.http.WebRequest;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;
import com.sangupta.jerry.util.UriUtils;

public class HttpElasticSearchClientImpl implements ElasticSearchClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpElasticSearchClientImpl.class);
	
	protected final String elasticSearchServer;
	
	public HttpElasticSearchClientImpl(String elasticSearchServer) {
		this.elasticSearchServer = elasticSearchServer;
	}
	
	@Override
	public boolean existsIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.elasticSearchServer, indexName);
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
	public IndexResult createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings) throws IndexAlreadyExistsException {
		if(AssertUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Index name cannot be empty/null");
		}
		
		if(!name.equals(name.toLowerCase())) {
			throw new IllegalArgumentException("Index name must be lowercase");
		}
		
		if(settings == null) {
			throw new IllegalArgumentException("IndexSettings cannot be null - use a default instance instead");
		}
		
		if(mappings == null) {
			throw new IllegalArgumentException("IndexMappings cannot be null");
		}
		
		String endPoint = UriUtils.addWebPaths(this.elasticSearchServer, name);
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
	public IndexResult indexDocument(String index, String mapping, String documentID, Object document) {
		if(AssertUtils.isEmpty(index)) {
			throw new IllegalArgumentException("Index name cannot be empty/null");
		}
		
		if(!index.equals(index.toLowerCase())) {
			throw new IllegalArgumentException("Index name must be lowercase");
		}
		
		String endPoint = UriUtils.addWebPaths(this.elasticSearchServer, index, mapping, documentID);
		WebRequest request = WebRequest.put(endPoint);
		String requestBody = GsonUtils.getGson().toJson(document);
		LOGGER.debug("DocumentIndex request as: {}", requestBody);
		request.bodyString(requestBody, HttpMimeType.JSON);
		
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
	public IndexDetails getIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.elasticSearchServer, indexName);
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
	public boolean deleteIndex(String indexName) {
		String endPoint = UriUtils.addWebPaths(this.elasticSearchServer, indexName);
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
}
