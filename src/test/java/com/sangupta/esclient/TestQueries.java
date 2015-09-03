package com.sangupta.esclient;

import com.sangupta.esclient.domain.SearchQuery;
import com.sangupta.esclient.domain.search.SearchOperator;
import com.sangupta.esclient.domain.search.field.SearchField;
import com.sangupta.esclient.domain.search.filter.TermsFilter;
import com.sangupta.esclient.domain.search.query.FilteredSearchQuery;
import com.sangupta.esclient.domain.search.query.MatchQuery;
import com.sangupta.jerry.util.GsonUtils;

public class TestQueries {
	
	public static void main(String[] args) {
		SearchField field = new SearchField("this is a test");
		SearchQuery query = new MatchQuery("message", field);
		System.out.println(GsonUtils.getGson().toJson(query));
		
		field = new SearchField("this is a test", SearchOperator.AND);
		query = new MatchQuery("message", field);
		System.out.println(GsonUtils.getGson().toJson(query));
		
		query = new FilteredSearchQuery(new MatchQuery("content", new SearchField("course")), new TermsFilter("docID", new String[] { "doc1", "doc2" }));
		System.out.println(GsonUtils.getGson().toJson(query));
	}

}
