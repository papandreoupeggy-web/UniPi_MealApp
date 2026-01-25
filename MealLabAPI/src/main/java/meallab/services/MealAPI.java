package meallab.services;

//creation of public class for initialization of MealDBService class
public class MealAPI {
	public static MealDBService getMealDBService() {// public method to call API in any point of the script 
		return new MealDBService("https://www.themealdb.com", "1"); //API URL & Public Key
	}

}
