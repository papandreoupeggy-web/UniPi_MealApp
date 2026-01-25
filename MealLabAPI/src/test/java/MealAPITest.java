import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import meallab.exceptions.MealAPIException;
import meallab.model.Meals;
import meallab.services.MealAPI; //this class was copied by the default package 
import meallab.services.MealDBService; //add of class MealDBService to

//https://www.geeksforgeeks.org/software-testing/junit-sample-test-cases-for-string-java-service
//https://www.vogella.com/tutorials/JUnit4/article.html
public class MealAPITest {	
 
	//@Before
	//public void setUp() throws Exception {
	//}

	@Test //for API Searching 
	public void testSearchAPI() throws MealAPIException{
		final MealDBService mealSearchService = MealAPI.getMealDBService();
		final Meals results = mealSearchService.getRandomMeal();
		assertNotNull(results);
		assertFalse(results.getMeals().isEmpty());
		results.getMeals().forEach(meal ->System.out.println(meal.getStrMeal())); //use of Lambda Expression
		
		//fail("Not yet implemented");
	}
	
	@Test //for API Discovery in general
	public void testDiscoveryAPI() throws MealAPIException{
		final MealDBService mealSearchService = MealAPI.getMealDBService();
		final Meals results = mealSearchService.getRandomMeal();
		assertNotNull(results);
		assertFalse(results.getMeals().isEmpty());
		results.getMeals().forEach(meal ->System.out.println(meal.getStrMeal())); //use of Lambda Expression
		

	}

	@Test //for API Discovery by Meal Name
	public void testDiscoveryAPIbyName() throws MealAPIException{
		final MealDBService mealSearchService = MealAPI.getMealDBService();
		final Meals results = mealSearchService.searchMealByName("Arrabiata");
		assertNotNull(results);
		assertFalse(results.getMeals().isEmpty());
		results.getMeals().forEach(meal ->System.out.println(meal.getStrMeal())); //use of Lambda Expression
	}	

	@Test //for API Discovery by Meal ID
	public void testDiscoveryAPIbyRecipe() throws MealAPIException{
		final MealDBService mealSearchService = MealAPI.getMealDBService();
		final Meals results = mealSearchService.searchMealById("52772");
		assertNotNull(results);
		assertFalse(results.getMeals().isEmpty());
		results.getMeals().forEach(meal ->System.out.println(meal.getStrMeal())); //use of Lambda Expression
	}	
	
}
