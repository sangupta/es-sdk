package com.sangupta.esclient.domain.field;

import com.google.gson.annotations.SerializedName;
import com.sangupta.esclient.domain.IndexField;

public class DateField extends IndexField {
	
	protected DateFieldFormat format;
	
	@SerializedName("precision_step")
	protected Integer precisionStep;
	
	@SerializedName("ignore_malformed")
	protected Boolean ignore_malformed;
	
	@SerializedName("numeric_resolution")
	protected DateUnit numericResolution;

	protected DateField(FieldType type) {
		super(FieldType.Date);
	}
	
	/**
	 * Default constructor
	 * 
	 */
	public DateField() {
		super(FieldType.Date);
	}

	public DateField(DateFieldFormat format) {
		this();
		this.format = format;
	}
	
	// Usual accessors follow

	/**
	 * @return the format
	 */
	public DateFieldFormat getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(DateFieldFormat format) {
		this.format = format;
	}

	/**
	 * @return the precisionStep
	 */
	public Integer getPrecisionStep() {
		return precisionStep;
	}

	/**
	 * @param precisionStep the precisionStep to set
	 */
	public void setPrecisionStep(Integer precisionStep) {
		this.precisionStep = precisionStep;
	}

	/**
	 * @return the ignore_malformed
	 */
	public Boolean getIgnore_malformed() {
		return ignore_malformed;
	}

	/**
	 * @param ignore_malformed the ignore_malformed to set
	 */
	public void setIgnore_malformed(Boolean ignore_malformed) {
		this.ignore_malformed = ignore_malformed;
	}

	/**
	 * @return the numericResolution
	 */
	public DateUnit getNumericResolution() {
		return numericResolution;
	}

	/**
	 * @param numericResolution the numericResolution to set
	 */
	public void setNumericResolution(DateUnit numericResolution) {
		this.numericResolution = numericResolution;
	}
	
}
