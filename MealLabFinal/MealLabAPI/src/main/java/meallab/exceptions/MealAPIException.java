	package meallab.exceptions;
	
	//Inheritance for MealAPIException so we can understand the cause of error//
	
	public class MealAPIException extends Exception{
		public MealAPIException() {
			super();
		}
		
	//addition of constructors to print messages for each cause of error//
	public MealAPIException(String message) {
		super(message);
	}
	
	public MealAPIException(String message, Throwable cause) {
		super(message,cause);
	}
	public MealAPIException(Throwable cause) {
		super(cause);
	}
	protected MealAPIException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace ) {
		super(message,cause, enableSuppression,writeableStackTrace);
	}
	}
	
	

