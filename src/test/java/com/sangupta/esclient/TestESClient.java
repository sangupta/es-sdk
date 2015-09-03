package com.sangupta.esclient;

import java.util.HashMap;
import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.domain.analysis.CustomAnalyzer;
import com.sangupta.esclient.domain.analysis.MappingCharFilter;
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
		IndexSettings settings = new IndexSettings();
		
		String customAnalyzer = "custom_text_analyzer";
		settings.addAnalyzer(customAnalyzer, new CustomAnalyzer("standard", "custom_char_filter"));
		MappingCharFilter mappingCharFilter = new MappingCharFilter();
		char c = 0xFFFD;
		mappingCharFilter.addCharMapping(String.valueOf(c), "-");
		settings.addCharFilter("custom_char_filter", mappingCharFilter);

		IndexMapping articles = new IndexMapping();
		articles.addIndexField("_id", new StringField(FieldAnalysis.NotAnalyzed));
		articles.addIndexField("docID", new StringField(FieldAnalysis.NotAnalyzed));
		articles.addIndexField("docName", new StringField());
		articles.addIndexField("url", new StringField());
		articles.addIndexField("author", new StringField());
		articles.addIndexField("title", new StringField());
		articles.addIndexField("text", new StringField());
		articles.addIndexField("updated", new DateField(DateFieldFormat.EpochMillis));
		
		Map<String, IndexMapping> mappings = new HashMap<>();
		mappings.put("articles", articles);
		
		client.createIndex(indexName, settings, mappings);
	}

}
