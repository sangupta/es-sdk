package com.sangupta.esclient;

import java.util.HashMap;
import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.domain.analysis.CustomAnalyzer;
import com.sangupta.esclient.domain.analysis.MappingCharFilter;
import com.sangupta.esclient.domain.analysis.StopWordAnalyzerFilter;
import com.sangupta.esclient.domain.field.DateField;
import com.sangupta.esclient.domain.field.DateFieldFormat;
import com.sangupta.esclient.domain.field.FieldAnalysis;
import com.sangupta.esclient.domain.field.StringField;
import com.sangupta.esclient.impl.HttpElasticSearchClientImpl;

public class TestESClient {
	
	public static void main(String[] args) {
		final String indexName = "testindex";
		final ElasticSearchClient client = new HttpElasticSearchClientImpl("http://localhost:9200/");
		
		if(client.existsIndex("testindex")) {
			client.deleteIndex("testindex");
		}
		
		// create index settings
		IndexSettings settings = new IndexSettings();

		// a new mapping filter
		MappingCharFilter mappingCharFilter = new MappingCharFilter();
		mappingCharFilter.addCharMapping(String.valueOf((char) 0xFFFD), "-");
		settings.addCharFilter("custom_char_filter", mappingCharFilter);
		
		// a new stop word filter
		StopWordAnalyzerFilter filter = new StopWordAnalyzerFilter();
		filter.addStopWords(new String[] { "adobe", "google", "microsoft", "apple" });
		settings.addAnalyzerFilter("custom_filter", filter);

		// a new custom analyzer
		String customAnalyzer = "custom_text_analyzer";
		settings.addAnalyzer(customAnalyzer, new CustomAnalyzer("standard", "custom_char_filter", "custom_filter"));

		// create the type mapping
		IndexMapping articles = new IndexMapping();
		articles.addIndexField("_id", new StringField(FieldAnalysis.NotAnalyzed));
		articles.addIndexField("docID", new StringField(FieldAnalysis.NotAnalyzed));
		articles.addIndexField("docName", new StringField());
		articles.addIndexField("url", new StringField());
		articles.addIndexField("author", new StringField());
		articles.addIndexField("title", new StringField());
		articles.addIndexField("text", new StringField());
		articles.addIndexField("updated", new DateField(DateFieldFormat.EpochMillis));
		
		// add to index
		Map<String, IndexMapping> mappings = new HashMap<>();
		mappings.put("articles", articles);
		
		// go create index
		client.createIndex(indexName, settings, mappings);
	}

}
