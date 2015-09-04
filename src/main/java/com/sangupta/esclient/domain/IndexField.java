package com.sangupta.esclient.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sangupta.esclient.domain.field.FieldAnalysis;
import com.sangupta.esclient.domain.field.FieldType;
import com.sangupta.esclient.domain.field.MultiFieldDetail;
import com.sangupta.esclient.domain.field.NullValue;
import com.sangupta.esclient.domain.field.SimilarityAlgo;

public abstract class IndexField {

	protected final FieldType type;
	
	protected Boolean store;
	
	protected Double boost;
	
	protected FieldAnalysis index;
	
	protected NullValue nullValue;

	protected Boolean docValues;
	
	protected Boolean includeInAll;
	
	protected SimilarityAlgo similarity;
	
	protected Set<String> copyTo;
	
	protected Map<String, MultiFieldDetail> fields;
	
	/**
	 * Default constructor
	 * 
	 * @param type the {@link FieldType} to use
	 * 
	 */
	protected IndexField(FieldType type) {
		this.type = type;
	}

	/**
	 * Convenience constructor
	 * 
	 * @param fieldName the name of the field
	 */
	public void addCopyTo(String fieldName) {
		if(this.copyTo == null) {
			this.copyTo = new HashSet<>();
		}
		
		this.copyTo.add(fieldName);
	}
	
	/**
	 * Add a field alias.
	 * 
	 * @param name the name of the field
	 * 
	 * @param details the multi-field details
	 */
	public void addFieldAlias(String name, MultiFieldDetail details) {
		if(this.fields == null) {
			this.fields = new HashMap<>();
		}
		
		this.fields.put(name, details);
	}
	
	/**
	 * Add a field alias.
	 * 
	 * @param name the name of the field
	 * 
	 * @param type the {@link FieldType} to add
	 * 
	 * @param analysis the {@link FieldAnalysis} to use
	 */
	public void addAlias(String name, FieldType type, FieldAnalysis analysis) {
		this.addFieldAlias(name, new MultiFieldDetail(type, analysis));
	}
	
	// Usual accessors follow

	/**
	 * @return the type
	 */
	public FieldType getType() {
		return type;
	}

	/**
	 * @return the index
	 */
	public FieldAnalysis getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(FieldAnalysis index) {
		this.index = index;
	}

	/**
	 * @return the store
	 */
	public Boolean getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Boolean store) {
		this.store = store;
	}

	/**
	 * @return the boost
	 */
	public Double getBoost() {
		return boost;
	}

	/**
	 * @param boost the boost to set
	 */
	public void setBoost(Double boost) {
		this.boost = boost;
	}

	/**
	 * @return the nullValue
	 */
	public NullValue getNullValue() {
		return nullValue;
	}

	/**
	 * @param nullValue the nullValue to set
	 */
	public void setNullValue(NullValue nullValue) {
		this.nullValue = nullValue;
	}

	/**
	 * @return the docValues
	 */
	public Boolean getDocValues() {
		return docValues;
	}

	/**
	 * @param docValues the docValues to set
	 */
	public void setDocValues(Boolean docValues) {
		this.docValues = docValues;
	}

	/**
	 * @return the includeInAll
	 */
	public Boolean getIncludeInAll() {
		return includeInAll;
	}

	/**
	 * @param includeInAll the includeInAll to set
	 */
	public void setIncludeInAll(Boolean includeInAll) {
		this.includeInAll = includeInAll;
	}

	/**
	 * @return the similarity
	 */
	public SimilarityAlgo getSimilarity() {
		return similarity;
	}

	/**
	 * @param similarity the similarity to set
	 */
	public void setSimilarity(SimilarityAlgo similarity) {
		this.similarity = similarity;
	}

	/**
	 * @return the copyTo
	 */
	public Set<String> getCopyTo() {
		return copyTo;
	}

	/**
	 * @param copyTo the copyTo to set
	 */
	public void setCopyTo(Set<String> copyTo) {
		this.copyTo = copyTo;
	}

	/**
	 * @return the fields
	 */
	public Map<String, MultiFieldDetail> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(Map<String, MultiFieldDetail> fields) {
		this.fields = fields;
	}

}
