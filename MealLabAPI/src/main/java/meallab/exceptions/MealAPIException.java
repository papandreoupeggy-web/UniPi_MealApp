	package meallab.exceptions; //creation of this package for exception handling
	
	//Inheritance for MealAPIException so we can understand the cause of error//
	//use Exception class to handle overload exceptions and create custom class
	public class MealAPIException extends Exception{ //extend super class Exception
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L; // Unique identifier for serialization
		public MealAPIException() { //use default constructor 
			super(); //create new exception with no message
		}
		
	//addition of constructors to print messages for each cause of error//
	public MealAPIException(String message) {  //create new exception with message
		super(message);
	}
	
	public MealAPIException(String message, Throwable cause) {  //create new exception with message and cause
		super(message,cause);
	}
	public MealAPIException(Throwable cause) { //create new exception with cause
		super(cause);
	}
	//protected constructor with all the possibilities 
	protected MealAPIException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace ) {
		super(message,cause, enableSuppression,writeableStackTrace);
	}
	}
	
	

//end of MealAPIException class