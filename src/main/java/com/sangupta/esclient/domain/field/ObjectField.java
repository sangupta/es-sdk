package com.sangupta.esclient.domain.field;

import java.util.HashMap;
import java.util.Map;

import com.sangupta.esclient.domain.IndexField;

/**
 * @author sangupta
 *
 */
public class ObjectField extends IndexField {

	private Map<String, IndexField> properties;
	
	public ObjectField() {
		super(FieldType.Object);
	}

	public void addIndexField(String name, IndexField field) {
		if(this.properties == null) {
			this.properties = new HashMap<String, IndexField>();
		}
		
		this.properties.put(name, field);
	}
	
}
