package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexField;

public class NumberField extends IndexField {
	
	@SerializedName("precision_step")
	protected Integer precisionStep;
	
	@SerializedName("ignore_malformed")
	protected Boolean ignoreMalformed;
	
	@SerializedName("coerce")
	protected Boolean coerce;
	
	public NumberField(FieldType type) {
		super(type);
		
		switch (type) {
			case Byte:
			case Double:
			case Float:
			case Integer:
			case Long:
			case Short:
				break;
				
			case Date:
			case String:
			default:
				throw new IllegalArgumentException("Number field can only be of type: byte/double/float/integer/long/short");
		}
	}

}
