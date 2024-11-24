package com.hexaware.fastx.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	public EntityNotFoundException(String resourceName, String fieldName) {
		super(String.format("%s not found in %s", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
