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
public class FavoritesList implements EventHandler<MouseEvent>{ //for users' clicks { //new public class for favorite list on another scene
	
	Stage secondStage;
	
	Scene secondScene;
	
	FlowPane rootFlowPane;
	
	FlowPane bottomRightButtonsPane;
	
	FlowPane buttonPane;

	FlowPane listPane;
	
	GridPane rootGridPane;
	
	ListView<Meal>favoritesListView;
	
	ArrayList<Meal> targetCookedList;//add the list so user can send their meals
	
	Button AddCookedBtn,DeleteBtn, BackBtn,DetailsBtn;
	
	TextArea responseArea;
	
	ImageView mealImageView;
	
	Meal selectedMeal;
	
	Scene previousScene;
	
	Scene sendScene;
	
	Stage mainStage;
	
	//public constructor
	public FavoritesList(Stage secondStage, Scene prevScene,ArrayList<Meal> mealsList, ArrayList<Meal> cookedList){ //for users' clicks{
		this.secondStage = secondStage;
        this.previousScene = prevScene;  
        this.mainStage=secondStage;
        //for data saving
        this.targetCookedList=cookedList;
       
        
		
	//initialization of values
    AddCookedBtn=new Button("Add to Cooked");   
    AddCookedBtn.setStyle("-fx-background-color: #82E0AA; -fx-text-fill: white;-fx-font-weight: bold;");
    DeleteBtn=new Button("Delete from the list");
    DeleteBtn.setStyle("-fx-background-color: #D98880; -fx-text-fill: white;-fx-font-weight: bold;");
    BackBtn=new Button("Back on the Main Μenu");
    BackBtn.setStyle("-fx-background-color: #F8C471; -fx-text-fill: white; -fx-font-weight: bold;");
    DetailsBtn=new Button("Show Details");
    DetailsBtn.setStyle("-fx-background-color: #85C1E9; -fx-text-fill: white; -fx-font-weight: bold;");
    
    String pageTitle = "Favorite List";
	Label label = new Label(pageTitle);
	label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-padding: 10px;");
	favoritesListView =new ListView<Meal>();
	favoritesListView.setPrefHeight(350); 
    favoritesListView.setPrefWidth(300);
    favoritesListView.setStyle("-fx-font-size: 14px; -fx-border-color: #F5B7B1;");
    
    mealImageView = new ImageView();
    

	rootFlowPane=new FlowPane();
	rootGridPane=new GridPane();
	buttonPane=new FlowPane();
	bottomRightButtonsPane=new FlowPane();
	responseArea =new TextArea();
	responseArea.setEditable(false);
    responseArea.setWrapText(true);
    responseArea.setPrefHeight(120); 
    responseArea.setPrefWidth(400);
    responseArea.setStyle("-fx-control-inner-background: #F4F6F6;");
	selectedMeal=new Meal();
	
	  //dimensions for very item on the scene
	buttonPane.setAlignment(Pos.CENTER);
    buttonPane.getChildren().add(AddCookedBtn);
    
    bottomRightButtonsPane.setAlignment(Pos.CENTER);
    bottomRightButtonsPane.setHgap(15);
    bottomRightButtonsPane.getChildren().addAll(DeleteBtn, BackBtn,DetailsBtn);
	
  //image dimensions
    mealImageView.setFitWidth(250);
    mealImageView.setPreserveRatio(true);
    
	//create static filter to field out the list
	
	if(mealsList !=null && !mealsList.isEmpty()) { //if the list is note empty then fill it out
		favoritesListView.getItems().addAll(mealsList);
	}else {favoritesListView.setPlaceholder(new Label("Empty List")); //new object
	}

	//add the characteristics
	secondScene=new Scene(rootGridPane,850,700);
	secondStage.setTitle(pageTitle);
	
	rootGridPane.setAlignment(Pos.CENTER);
    rootGridPane.setVgap(15);
    rootGridPane.setHgap(10);
    rootGridPane.setStyle("-fx-background-color: #FAFAFA;");
    rootGridPane.add(label, 0, 0);
    rootGridPane.add(favoritesListView, 0, 1);
    rootGridPane.add(buttonPane, 0, 2);
    rootGridPane.add(bottomRightButtonsPane, 0, 3);
    rootGridPane.add(responseArea, 0, 4,2, 1);
    rootGridPane.add(mealImageView, 1, 1);
	
	rootFlowPane.setHgap(15);
	rootFlowPane.setVgap(15);
	rootFlowPane.setAlignment(Pos.CENTER);
	
	//to handle on click action from the buttons
	 BackBtn.setOnMouseClicked(this);
	 AddCookedBtn.setOnMouseClicked(this);
	 DeleteBtn.setOnMouseClicked(this);
	 DetailsBtn.setOnMouseClicked(this);
	}	
public Scene getScene() { //to call this scene by the previous one
    return secondScene;
}

@Override //public method for mouse events by user handling
public void handle(MouseEvent event) {
	try {
    if (event.getSource() == BackBtn) {
        mainStage.setTitle("The Meal Lab App");
        mainStage.setScene(previousScene);

    }else if(event.getSource() == DeleteBtn){
    	 handleDelete();
    
	}else if(event.getSource() == AddCookedBtn ) {
		handleAddCooked();
		
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
	selectedMeal=favoritesListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) {//if user don't select a meal add click the button 
		responseArea.setText("Please select a meal first");
		
	} else { 
    	responseArea.setText("🍽️🧑🏻‍🍳"); //erase the previous answers
    	responseArea.appendText("Name: " + selectedMeal.getStrMeal() +"\n");
    	responseArea.appendText("Ingredients: " +"\n"+ selectedMeal.getIngredientsList()+"\n");
        responseArea.appendText("Instructions:" +"\n"+ selectedMeal.getStrInstructions()+"\n");
    	responseArea.appendText("🍽️🧑🏻‍🍳");
    }
	try {//Exception handling for image
        if (selectedMeal.getStrMealThumb() != null && !selectedMeal.getStrMealThumb().isEmpty()) {
            mealImageView.setImage(new Image(selectedMeal.getStrMealThumb())); //don't view null values
        } else {
            mealImageView.setImage(null); //don't view null image
        }
    } catch (Exception e) {
        System.out.println("Image error: " + e.getMessage()); //arise error in the programmer if the image not loading
        mealImageView.setImage(null);
    }
}
	

private void handleAddCooked() {
	// TODO Auto-generated method stub
	selectedMeal=favoritesListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) {
		responseArea.setText("You can't add an empty value on list"); //if user don't select a meal add click the button 
	}else {//saving on the list
		targetCookedList.add(selectedMeal);
		//save of list when shutdown
		DataSaving.saveList(targetCookedList, "cooked.dat");		
		responseArea.setText(selectedMeal.getStrMeal() + " " +" is added on your Cooked List");
		
	}
	
}

private void handleDelete() {
	// TODO Auto-generated method stub
	selectedMeal=favoritesListView.getSelectionModel().getSelectedItem();
	if (selectedMeal == null) {
		responseArea.setText("Please select the meal that you want to delete from the list");
	}else { //https://stackoverflow.com/questions/75416728/javafx-remove-selected-items-in-a-listview
		favoritesListView.getItems().removeAll(favoritesListView.getSelectionModel().getSelectedItems());
		responseArea.setText(selectedMeal.getStrMeal() + " " +  "is deleted from the list");
	//for data saving- conversion to arraylist
		ArrayList<Meal> updatedList = new ArrayList<>(favoritesListView.getItems());
        DataSaving.saveList(updatedList, "favorites.dat");
	}
	
}
}
