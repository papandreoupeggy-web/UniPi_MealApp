package papandreou.unipi.meallab.MealLabGUIFINAL;
//https://www.geeksforgeeks.org/java/serialization-and-deserialization-in-java/
import java.io.*;
import java.util.ArrayList;
import meallab.model.Meals.Meal;

public class DataSaving{
	//serialization for data saving as a list
	public static void saveList(ArrayList<Meal> list, String filename) {
		try {
			//creation of file for saving the saving (output)
			FileOutputStream file=new FileOutputStream(filename);
			ObjectOutputStream out= new ObjectOutputStream(file);
			out.writeObject(list);//list saving
			//closure of streams
			out.close();
			file.close();
			System.out.println("Serialized list as"+ " "+filename);
			
			//exception handling
		}catch(IOException ex) {
			System.out.println("IOException during saving");
			ex.printStackTrace();
		}
	}
	//create method for deserialization
	@SuppressWarnings("unchecked")
	public static ArrayList<Meal> loadList(String filename){
		ArrayList<Meal> list=new ArrayList<>();
		
		//check if is file already exists
		File f= new File(filename);
		if(!f.exists()) {
			return list;  //return null if it is the first time that user open the app
	}

		try {FileInputStream file=new FileInputStream(filename);
		ObjectInputStream in= new ObjectInputStream(file);
		//conversion for reading as Arraylist (Casting)
		list = (ArrayList<Meal>) in.readObject();
		in.close();
		file.close();
		System.out.println("Deserialized list as"+ " "+filename);
		}catch(IOException ex) {
			System.out.println("IOException during loading");
		} catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        
        return list;
    }
}

