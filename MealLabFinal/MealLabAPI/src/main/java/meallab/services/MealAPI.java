package meallab.services;
import meallab.services.MealDBService;

public class MealAPI {
	public static MealDBService getMealDBService() {
		return new MealDBService("https://www.themealdb.com", "1");
	}

}
