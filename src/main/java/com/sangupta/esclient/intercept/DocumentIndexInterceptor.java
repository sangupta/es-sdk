package com.sangupta.esclient.intercept;

import com.google.gson.JsonElement;

public interface DocumentIndexInterceptor<T> {
	
	public boolean beforeSerialization(T entity);
	
	public boolean afterSerialization(JsonElement jsonElement);
	
}
