package com.sangupta.esclient.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.search.SearchType;

public class SearchQuery {
	
	@SerializedName("query")
	private String query;
	
	private List<String> indexes;
	
	private List<String> types;
	
	@SerializedName("from")
	private long from;
	
	@SerializedName("size")
	private int size;
	
	@SerializedName("search_type")
	private SearchType searchType;

	private boolean explain;
	
	// Usual accessors follow

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the indexes
	 */
	public List<String> getIndexes() {
		return indexes;
	}

	/**
	 * @param indexes the indexes to set
	 */
	public void setIndexes(List<String> indexes) {
		this.indexes = indexes;
	}

	/**
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}

	/**
	 * @return the from
	 */
	public long getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(long from) {
		this.from = from;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the searchType
	 */
	public SearchType getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return the explain
	 */
	public boolean isExplain() {
		return explain;
	}

	/**
	 * @param explain the explain to set
	 */
	public void setExplain(boolean explain) {
		this.explain = explain;
	}
	
}
