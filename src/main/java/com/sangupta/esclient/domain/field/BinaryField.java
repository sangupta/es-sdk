package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexField;

public class BinaryField extends IndexField {
	
	protected Boolean compress;
	
	@SerializedName("compress_threshold")
	protected Long compressThreshold;

	protected BinaryField(FieldType type) {
		super(FieldType.Binary);
	}

}
