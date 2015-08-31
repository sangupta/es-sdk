package com.sangupta.esclient;

import java.util.HashMap;
import java.util.Map;

import com.sangupta.esclient.domain.IndexMapping;
import com.sangupta.esclient.domain.IndexSettings;
import com.sangupta.esclient.domain.field.DateField;
import com.sangupta.esclient.domain.field.DateFieldFormat;
import com.sangupta.esclient.domain.field.FieldAnalysis;
import com.sangupta.esclient.domain.field.StringField;

public class TestESClient {
	
	public static void main(String[] args) {
		ElasticSearchClient client = null;
		
		IndexSettings settings = new IndexSettings();
		
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
		
		client.createIndex("testIndex", settings, mappings);
	}

}
