/*************************************************************************
 *
 * MultiPLX Confidential
 * _____________________
 *
 * Copyright (C) 2012-2014, MultiPLX Founders.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of MultiPLX and its founders. The intellectual and technical 
 * concepts contained herein are proprietary to the MultiPLX owners 
 * mentioned elsewhere, and may be covered by U.S. and Foreign Patents, 
 * patents in process, and are protected by trade secret or copyright law. 
 * Dissemination of this information or reproduction of this material is 
 * strictly forbidden unless prior written permission is obtained from 
 * all persons mentioned before. Please see project license for more 
 * details.
 *
 **************************************************************************/


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
	
	/**
	 * @param type
	 */
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
