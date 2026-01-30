package papandreou.unipi.meallab.MealLabGUIFINAL;

//https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
//for data saving
import java.util.ArrayList;

//https://fxdocs.github.io/docs/html5/
//primary scene as "welcome" for the app
import javafx.application.Application;//import of super class Application to extend it
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import meallab.model.Meals.Meal;

/**

* JavaFX App

*/

//super class Application extended by App
public class App extends Application implements EventHandler<MouseEvent>{//add event handling for user's actions

//Addition of Stage
Stage mainStage;

//Scenes
Scene mainScene,mealScene;

//root node by using flow pane type
FlowPane rootFlowPane, mealFlowPane;

//Buttons that will appears on the scene
Button StartBtn;

//lists for data saving
ArrayList<Meal> favoritesList;
ArrayList<Meal> cookedList;

@Override //use override to avoid compilation errors

public void start(Stage mainstage) { //public method for the creation of the main stage of the app
this.mainStage = mainstage;

//read the saved data when app opens
favoritesList = DataSaving.loadList("favorites.dat");
cookedList = DataSaving.loadList("cooked.dat");

//creation of Flow Pane view and buttons and set style accordingly
rootFlowPane = new FlowPane();
rootFlowPane.setStyle("-fx-background-color: #FFF3E0;");
StartBtn = new Button ("What's on the menu today?");
StartBtn.setStyle("-fx-background-color: #FF5722; " +"-fx-text-fill: white; " +"-fx-font-weight: bold; ");


//handle event on Start Button
StartBtn.setOnMouseClicked(this);


//set features for each item

rootFlowPane.setHgap(10);
rootFlowPane.setAlignment(Pos.CENTER);
StartBtn.setMinSize(120,30);



//addition of buttons to the root flow pane
rootFlowPane.getChildren().add( StartBtn);


//create new java object to add measures in the main scene
mainScene = new Scene(rootFlowPane,650,300);
mainstage.setTitle("The Meal Lab App"); //setter to print a specific title for the main stage
mainstage.setScene(mainScene);
mainstage.show();

}

public static void main(String[] args) { //main method of this class
launch(); //start the app
}

@Override //interlink the main and the second scene
//start of handle public method
public void handle(MouseEvent event) { 
if (event.getSource() == StartBtn) {
LabMenuView menuView = new LabMenuView(mainStage, mainScene, favoritesList,cookedList); 
mainStage.setTitle("Today's Menu");//set title
mainStage.setScene(menuView.getScene()); //set scene

}	
}
//end of handle public method
} //end of App class