package com.example.ShopWebAPI.exception;

public class ResourceNotFoundException extends RuntimeException{
		private String resourceName;
		private String propertyName;
		private String propertyValue;
		public ResourceNotFoundException(String resourceName, String propertyName, String propertyValue) {
			super(String.format("Not found %s with %s = %s", resourceName,propertyName,propertyValue));
			this.resourceName = resourceName;
			this.propertyName = propertyName;
			this.propertyValue = propertyValue;
		}
		
}
