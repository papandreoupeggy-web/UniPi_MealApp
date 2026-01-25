package papandreou.unipi.meallab.MealLabGUIFINAL;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;
//import all the necessary classes by the library of the first part of the project
import meallab.exceptions.MealAPIException;
import meallab.model.Meals;
import meallab.model.Meals.Meal;
import meallab.services.MealAPI;
import meallab.services.MealDBService;

//https://www.sitepoint.com/community/t/help-with-making-a-scene-in-javafx/354258//
//https://docs.oracle.com/javafx/2/api/javafx/geometry/Pos.html#TOP_RIGHT//
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html#wrapTextProperty
//https://www.tutorialspoint.com/javafx/javafx_textarea.htm
//https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html

public class LabMenuView implements EventHandler<MouseEvent>{ //for users' clicks

	//add values
    GridPane rootGridPane, inputFieldsPane;

    Label button;

    TextField paramField;

    FlowPane buttonFlowPane;
    
    FlowPane bottomRightButtonsPane;

    Button SearchBtn,RandomBtn,AddFavoriteBtn, AddCookedBtn, BackBtn, FavoritesBtn, CookedBtn;
    
    TextArea responseArea;
    
    ArrayList<Meal>FavoritesList;
    ArrayList<Meal> CookedList;
    
    Meal printedMeal; //add so the list can see the meal on the screen right now
    
    ImageView mealImageView;
    
    Scene scene;

    Stage mainStage;

    Scene previousScene;
    
//for API calling
    MealDBService mealService;
    
    //initialize the above objects
    public LabMenuView(Stage stage,Scene prevScene,ArrayList<Meal> favorites, ArrayList<Meal> cooked) { //add constructors with values so this page can see the previous one
        this.mainStage = stage;
        this.previousScene = prevScene;
        //initialize for API
        this.mealService = MealAPI.getMealDBService();
        
        //use of existed lists for data saving
        this.FavoritesList = favorites;
        this.CookedList = cooked;

        rootGridPane=new GridPane();
        inputFieldsPane=new GridPane();
        buttonFlowPane=new FlowPane();
        bottomRightButtonsPane= new FlowPane();

        Label textLbl = new Label("Insert Name or Ingredients: ");
        paramField=new TextField();
        SearchBtn=new Button("Search");
        SearchBtn.setStyle("-fx-background-color: #85C1E9; -fx-text-fill: white; -fx-font-weight: bold;");
        RandomBtn=new Button ("Random");
        RandomBtn.setStyle("-fx-background-color: #D7BDE2; -fx-text-fill: white;-fx-font-weight: bold;");
        AddFavoriteBtn=new Button ("Add to Favorite");
        AddFavoriteBtn.setStyle("-fx-background-color: #F1948A; -fx-text-fill: white; -fx-font-weight: bold;");
        AddCookedBtn=new Button("Add to Cooked");
        AddCookedBtn.setStyle("-fx-background-color: #82E0AA; -fx-text-fill: white;-fx-font-weight: bold;");
        BackBtn=new Button ("Go Back");
        BackBtn.setStyle("-fx-background-color: #F8C471; -fx-text-fill: white;-fx-font-weight: bold;");
        FavoritesBtn= new Button ("Favorite");
        FavoritesBtn.setStyle("-fx-border-color: #F1948A; -fx-border-width: 2px; -fx-background-color: transparent;");
        CookedBtn= new Button ("Cooked");
        CookedBtn.setStyle("-fx-border-color: #82E0AA; -fx-border-width: 2px; -fx-background-color: transparent;");
        mealImageView=new ImageView();
        
        //initialize the response area   
       responseArea =new TextArea();
       

                         
              
     //initialize the buttons
       
        buttonFlowPane.getChildren().add(SearchBtn);
        buttonFlowPane.getChildren().add(RandomBtn);
        buttonFlowPane.getChildren().add(AddFavoriteBtn);
        buttonFlowPane.getChildren().add(AddCookedBtn);
        buttonFlowPane.getChildren().add(BackBtn);
        bottomRightButtonsPane.getChildren().add(FavoritesBtn);
        bottomRightButtonsPane.getChildren().add(CookedBtn);
               
      //grid  demesions 
        rootGridPane.setAlignment(Pos.CENTER);
        rootGridPane.setVgap(20);
        rootGridPane.setHgap(15);
//buttons demesions 
        buttonFlowPane.setAlignment(Pos.CENTER_LEFT);
        buttonFlowPane.setHgap(15);

        rootGridPane.add(textLbl, 0, 0);
        GridPane.setHalignment(textLbl, HPos.CENTER);
        rootGridPane.add(paramField, 1, 0);

        rootGridPane.add(buttonFlowPane, 0, 1,3,1);
        GridPane.setHalignment(buttonFlowPane, HPos.CENTER);
        
        rootGridPane.add(bottomRightButtonsPane, 0,5, 3,1); 
        bottomRightButtonsPane.setAlignment(Pos. BOTTOM_RIGHT);
        bottomRightButtonsPane.setHgap(10);
        bottomRightButtonsPane.setVgap(20);
       
        rootGridPane.add(responseArea , 0,3,2,1);
        //image view details
        mealImageView.setFitWidth(300); 
        mealImageView.setPreserveRatio(true);
        rootGridPane.add(mealImageView, 2, 3);
        //scene demesions
        scene = new Scene(rootGridPane, 950, 650);
        //add text box to print responses on the screen of the user
        responseArea.setPrefRowCount(12); 
        responseArea.setPrefWidth(500);
        responseArea.setPrefHeight(400);
        responseArea.setWrapText(true);
        responseArea.setDisable(false);

//for click handle method
        SearchBtn.setOnMouseClicked(this);
        RandomBtn.setOnMouseClicked(this);
        AddFavoriteBtn.setOnMouseClicked(this);
        AddCookedBtn.setOnMouseClicked(this);
        BackBtn.setOnMouseClicked(this);
        FavoritesBtn.setOnMouseClicked(this);
        CookedBtn.setOnMouseClicked(this);    

    }

    public Scene getScene() {
        // TODO Auto-generated method stub
        return scene;
    }
//public method for exception handling on Click by create a loop for every btn
    @Override
    public void handle(MouseEvent event) {
    	// TODO Auto-generated method stub
    	try {
        if (event.getSource() == BackBtn) {
            mainStage.setTitle("The Meal Lab App");
            mainStage.setScene(previousScene);
        }
        else if (event.getSource() == SearchBtn) {
            handleSearch();
        }
        else if (event.getSource() == RandomBtn) {
            handleRandom();
        }
        else if (event.getSource() == AddFavoriteBtn) {
        	responseArea.setText("Added on Favourite List");
        	handleAddFavourites(); //create new method
        }
        else if (event.getSource() == AddCookedBtn) {
        	responseArea.setText("Added on Cooked List");
        	handleAddCooked(); //create new method
        }
        else if (event.getSource() == FavoritesBtn) {
        	responseArea.setText("Which is your next meal?");
        	handleShowFavourites();//create new method
        }
        else if (event.getSource() == CookedBtn) {
        	responseArea.setText("Let's see what you've cooked!");
        	handleShowCooked();//create new method
        }
        
        //if anything of the above then print an error message
    	} catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

//create a loop to handle all the situation about favourite and cooked lists
private void handleShowFavourites() {
		// TODO Auto-generated method stub
	if (FavoritesList.isEmpty()) {
	responseArea.setText("Your list is empty");
}else {
	FavoritesList favoritePage = new FavoritesList(mainStage, scene, FavoritesList, CookedList);//add cooked list so can be viewed by FavouritesList class
	mainStage.setTitle("Your Favorite List");
    mainStage.setScene(favoritePage.getScene());
}
	}

private void handleShowCooked() {
	// TODO Auto-generated method stub
	if (CookedList.isEmpty()) {
	responseArea.setText("Your list is empty");
}else {
	CookedList cookedPage=new CookedList(mainStage,scene,CookedList, FavoritesList); //add favorite list so can be viewed by CookedList class
	mainStage.setTitle("Cooked Meals");
	 mainStage.setScene(cookedPage.getScene());
}
}

private void handleAddFavourites() {
	// TODO Auto-generated method stub
	if (printedMeal == null) {
		responseArea.setText("You can't add an empty value on list");
	}else {
		FavoritesList.add(printedMeal);
		//final saving of the list
		DataSaving.saveList(FavoritesList, "favorites.dat");
		responseArea.setText(printedMeal.getStrMeal() + " " +" is added on your Favourites List");
		
	}
	}

private void handleAddCooked() {
	// TODO Auto-generated method stub
	if (printedMeal == null) {
		responseArea.setText("You can't add an empty value on list");
	}else {
		CookedList.add(printedMeal);
		//final saving of the list
		DataSaving.saveList(CookedList, "cooked.dat");
		responseArea.setText(printedMeal.getStrMeal() + " " +" is added on your Cooked List");
		
	}
	
}


//private method to handle Search btn
    private void handleSearch() {
        String userInput = paramField.getText().trim();
        if (userInput.isEmpty()) {
        	responseArea.setText("Empty Text");
            return;
        }
        responseArea.setText("I will check for: " + userInput);

        try {//don't return null values of the API 
            Meals results = mealService.searchMealByName(userInput);
            if (results.getMeals() != null && !results.getMeals().isEmpty()) {
            	responseArea.setText("Found " + results.getMeals().size() + " meal(s):");
//printed results if category or name is right
                for (Meal meal : results.getMeals()) {
                	printedMeal=meal; //to save the value to keep the last one
                	mealImageView.setImage(new Image(meal.getStrMealThumb()));
                	responseArea.setText("🍽️🧑🏻‍🍳"); //erase the previous answers
                	responseArea.appendText("Name: " + meal.getStrMeal() +"\n");
                	responseArea.appendText("Ingredients: " +"\n"+ meal.getIngredientsList()+"\n");
                    responseArea.appendText("Instructions:" +"\n"+ meal.getStrInstructions()+"\n");
                	responseArea.appendText("🍽️🧑🏻‍🍳");
                }
            } else { //if name or category is wrong
            	responseArea.setText("There is no meal with name: " + userInput +"\n");
            	mealImageView.setImage(null);
            }

        } catch (MealAPIException e) {
            System.err.println("API Error: " + e.getMessage()); //arise error in the programmer if the image not loading
            e.printStackTrace();
        }        
    }

//private method to handle Random Btn
    private void handleRandom() {
        try {
            Meals result = mealService.getRandomMeal();
            if (result.getMeals() != null && !result.getMeals().isEmpty()) { //don't view null values
                Meal randomMeal = result.getMeals().get(0);
                printedMeal=randomMeal; //to save the value not to be empty
                mealImageView.setImage(new Image(randomMeal.getStrMealThumb())); //image view
                responseArea.setText("🍽️🧑🏻‍🍳");
                responseArea.appendText("Today's meal is: " + randomMeal.getStrMeal()+"\n");
                responseArea.appendText("Ingredients: " +"\n"+ randomMeal.getIngredientsList()+"\n");
                responseArea.appendText("Instructions:" +"\n"+ randomMeal.getStrInstructions()+"\n");
                responseArea.appendText("🍽️🧑🏻‍🍳");
            }
        } catch (MealAPIException e) {
            System.err.println("API Error: " + e.getMessage());  //arise error in the programmer if the image not loading
            e.printStackTrace();
        }
    }
}
  
