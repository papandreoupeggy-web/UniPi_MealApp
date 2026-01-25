package papandreou.unipi.meallab.MealLabGUIFINAL;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import meallab.model.Meals.Meal;

//https://www.tutorialspoint.com/javafx/javafx_listview.htm
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SelectionModel.html#SelectionModel--
public class CookedList implements EventHandler<MouseEvent>{ //for users' clicks { //new public class for favourite list on another scene
	
	Stage thirdStage;
	
	Scene secondScene;
	
	FlowPane rootFlowPane;
	
	FlowPane bottomRightButtonsPane;
	
	FlowPane buttonPane;

	FlowPane listPane;
	
	GridPane rootGridPane;
	
	ListView<Meal>cookedListView;
	
	ArrayList<Meal> targetFavoritesList;//add the list so user can send their meals
	
	Button AddFavoritesBtn,DeleteBtn, BackBtn,DetailsBtn;
	
	TextArea responseArea;
	
	ImageView mealImageView;
	
	Meal selectedMeal;
	
	Scene previousScene;
	
	Scene thirdScene;
	
	Stage mainStage;
	
	//public constructor
	public CookedList(Stage thirdStage, Scene prevScene,ArrayList<Meal> mealsList, ArrayList<Meal> favoritesList){ //for users' clicks{
		this.thirdStage = thirdStage;
        this.previousScene = prevScene;  
        this.mainStage=thirdStage;
        this.targetFavoritesList=favoritesList;
		
	//initialization of values
    AddFavoritesBtn=new Button("Add to Favorites");   
    AddFavoritesBtn.setStyle("-fx-background-color: #F1948A; -fx-text-fill: white; -fx-font-weight: bold;");
    DeleteBtn=new Button("Delete from the list");
    DeleteBtn.setStyle("-fx-background-color: #D98880; -fx-text-fill: white;-fx-font-weight: bold;");
    BackBtn=new Button("Back on the Main Μenu");
    BackBtn.setStyle("-fx-background-color: #F8C471; -fx-text-fill: white; -fx-font-weight: bold;");
    DetailsBtn=new Button("Show Details");
    DetailsBtn.setStyle("-fx-background-color: #85C1E9; -fx-text-fill: white; -fx-font-weight: bold;");
    
    String pageTitle = "Cooked List";
	Label label = new Label(pageTitle);	
	label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-padding: 10px;");
	cookedListView =new ListView<Meal>();
	rootFlowPane=new FlowPane();
	rootGridPane=new GridPane();
	buttonPane=new FlowPane();
	bottomRightButtonsPane=new FlowPane();
	responseArea =new TextArea();
    mealImageView = new ImageView();
	selectedMeal=new Meal();
	
	
	//dimensions for very item on the scene
	cookedListView.setPrefHeight(350); 
    cookedListView.setPrefWidth(400);
    
    responseArea.setEditable(false);
    responseArea.setWrapText(true);
    responseArea.setPrefHeight(120); 
    responseArea.setPrefWidth(400);
    responseArea.setStyle("-fx-control-inner-background: #F4F6F6;");
    
    buttonPane.setAlignment(Pos.CENTER);
    buttonPane.getChildren().add(AddFavoritesBtn);
    
    bottomRightButtonsPane.setAlignment(Pos.CENTER);
    bottomRightButtonsPane.setHgap(15);
    bottomRightButtonsPane.getChildren().addAll(DeleteBtn, BackBtn, DetailsBtn);
    
    //image dimensions
    mealImageView.setFitWidth(250);
    mealImageView.setPreserveRatio(true);
    
	//create static filter to field out the list
	
	if(mealsList !=null && !mealsList.isEmpty()) { //if the list is note empty then fill it out
		cookedListView.getItems().addAll(mealsList);
	}else {cookedListView.setPlaceholder(new Label("Empty List")); //new object
	}

	//add the characteristics
	thirdScene=new Scene(rootGridPane,800,700);
	thirdStage.setTitle(pageTitle);
	
	rootGridPane.setAlignment(Pos.CENTER);
    rootGridPane.setVgap(15);
    rootGridPane.setHgap(15);
    rootGridPane.add(label, 0, 0);
    rootGridPane.add(cookedListView, 0, 1);
    rootGridPane.add(buttonPane, 0, 2);
    rootGridPane.add(bottomRightButtonsPane, 0, 3);
    
    //image placement
    rootGridPane.add(mealImageView, 1, 1);
     
    rootGridPane.add(responseArea, 0, 4);
	
	rootFlowPane.setHgap(10);
	rootFlowPane.setVgap(15);
	rootFlowPane.setAlignment(Pos.CENTER);
	
	//to handle on click action from the buttons
	 BackBtn.setOnMouseClicked(this);
	 AddFavoritesBtn.setOnMouseClicked(this);
	 DeleteBtn.setOnMouseClicked(this);
	 DetailsBtn.setOnMouseClicked(this);
	}	
public Scene getScene() { //to call this scene by the previous one
    return thirdScene;
}
//public method for mouse events handling by user
@Override
public void handle(MouseEvent event) {
	try {
    if (event.getSource() == BackBtn) {
        mainStage.setTitle("The Meal Lab App");
        mainStage.setScene(previousScene);

    }else if(event.getSource() == DeleteBtn){
    	 handleDelete();
    	 
	}else if(event.getSource() == AddFavoritesBtn ) {
		handleAddFavorites();
	
	}else if(event.getSource()==DetailsBtn) {
		handleShowDetails();
	}
	}catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}
	
	
private void handleShowDetails() {
	// TODO Auto-generated method stub
	// get the selected meal from the cooked list
	selectedMeal=cookedListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) { //if user don't select a meal add click the button 
		responseArea.setText("Please select a meal first");
		
	} else { //the response if the user select a meal
    	responseArea.setText("🍽️🧑🏻‍🍳"); //erase the previous answers
    	responseArea.appendText("Name: " + selectedMeal.getStrMeal() +"\n");
    	responseArea.appendText("Ingredients: " +"\n"+ selectedMeal.getIngredientsList()+"\n");
        responseArea.appendText("Instructions:" +"\n"+ selectedMeal.getStrInstructions()+"\n");
    	responseArea.appendText("🍽️🧑🏻‍🍳");
    	//Exception handling for image
    	try {
            if (selectedMeal.getStrMealThumb() != null && !selectedMeal.getStrMealThumb().isEmpty()) {
                mealImageView.setImage(new Image(selectedMeal.getStrMealThumb())); //don't view null values
            } else {
                mealImageView.setImage(null); //don't view null image
            }
        } catch (Exception e) {
            System.out.println("Image loading error: " + e.getMessage()); //arise error in the programmer if the image not loading
            mealImageView.setImage(null);
        }
    }
    }
	

private void handleAddFavorites() {
	// TODO Auto-generated method stub
	selectedMeal=cookedListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) { //if user don't select a meal add click the button 
		responseArea.setText("You can't add an empty value on list");
	}else {
		targetFavoritesList.add(selectedMeal); //save on the list even if the app shut down
		DataSaving.saveList(targetFavoritesList, "favorites.dat");
		responseArea.setText(selectedMeal.getStrMeal() + " " +" is added on your Favorites List");
		
	}
	
}

private void handleDelete() {
	// TODO Auto-generated method stub
	selectedMeal=cookedListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) {
		responseArea.setText("Please select the meal that you want to delete from the list");
	}else { //https://stackoverflow.com/questions/75416728/javafx-remove-selected-items-in-a-listview
		cookedListView.getItems().removeAll(cookedListView.getSelectionModel().getSelectedItems());
		responseArea.setText(selectedMeal.getStrMeal() + " " +  "is deleted from the list");
		//data saving when app shutdown
		ArrayList<Meal> updatedList = new ArrayList<>(cookedListView.getItems());
        DataSaving.saveList(updatedList, "cooked.dat");
	}
	
}
}
