package com.sangupta.esclient.intercept;

import com.google.gson.JsonElement;

public interface DocumentIndexInterceptor<T> {
	
	public String getUniqueInterceptorName();
	
	public boolean beforeSerialization(T entity);
	
	public boolean afterSerialization(JsonElement jsonElement);
	
}
