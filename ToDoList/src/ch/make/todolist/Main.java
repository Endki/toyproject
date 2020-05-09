package ch.make.todolist;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ch.make.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
			
			
//			MainView mainView=new MainView();
			
			Parent root=FXMLLoader.load(getClass().getResource("/ch/make/todolist/view/MainView.fxml"));
//			Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
//			Scene scene = new Scene(root,400,400);
			Scene scene = new Scene(root);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("ToDoList");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
