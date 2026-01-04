package papandreou.unipi.meallab.model;

import java.util.List; //import List class from java.util package//

//creation of Meals class for list of Meal objects//
public class Meals{
	
 private List<Meal> meals; //Meals array for list of Meal objects//
 public Meals(){} //default constructor for Jackson//
 public Meals(List<Meal> meals){ //constructor with parameters//
      this.meals = meals; //initialize meals array//
  }
  public List<Meal> getMeals() { //getter for the meals array//
      return meals;  //return meals array//
  }
  public void setMeals(List<Meal> meals) { //setter for meals array//
      this.meals = meals;} //set meals array//

  @Override
  public String toString() { //override toString method, to avoid compilation errors//
      return "Meals {meals=" + meals + "}"; //return string representation of Meals object//
  }
}
