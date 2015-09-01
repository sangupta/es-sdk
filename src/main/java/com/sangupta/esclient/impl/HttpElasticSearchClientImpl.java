package com.sangupta.esclient.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sangupta.esclient.ElasticSearchClient;
import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
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
	public void createIndex(String name, IndexSettings settings, Map<String, IndexMapping> mappings) {
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
		String requestBody = GsonUtils.getGson().toJson(new IndexCreationRequest(settings, mappings));
		LOGGER.debug("IndexCreation request as: {}", requestBody);
		request.bodyString(requestBody, HttpMimeType.JSON);
		
		WebResponse response = WebInvoker.executeSilently(request);
		if(response == null) {
			LOGGER.error("Unable to connect to elastic search server at {}", endPoint);
			return;
		}
		
		if(!response.isSuccess()) {
			LOGGER.warn("Non-success response for index creation from elastic search server at {}", endPoint);
			return;
		}
		
		LOGGER.debug("ElasticSearch response is: {}", response);
	}

	@Override
	public void indexDocument(String index, String mapping, String documentID, Object document) {
		// TODO Auto-generated method stub
		
	}

	private class IndexCreationRequest {
		
		IndexSettings settings;
		
		Map<String, IndexMapping> mappings;
		
		IndexCreationRequest(IndexSettings settings, Map<String, IndexMapping> mappings) {
			this.settings = settings;
			this.mappings = mappings;
		}
	}
}
