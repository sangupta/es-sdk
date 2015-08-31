package com.sangupta.esclient.domain;

import java.util.HashMap;
import java.util.Map;

public class IndexMapping {

	private Map<String, IndexField> properties;
	
	public void addIndexField(String name, IndexField field) {
		if(this.properties == null) {
			this.properties = new HashMap<String, IndexField>();
		}
		
		this.properties.put(name, field);
	}
	
}
