
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.stage.Stage;
import javafx.concurrent.Task;


public class GamePanel extends Application implements Runnable{

	final int originalTileSize = 16;
	
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	
	final int screenWidth = tileSize * maxScreenCol;
	
	final int screenHeight = tileSize * maxScreenRow;
	
	Thread gameThread;
	
	@Override
	public void start (Stage stage){
		
		Pane root = new Pane();
		Scene scene = new Scene(root, screenWidth, screenHeight );
		
		 Rectangle rec1 = new Rectangle(screenWidth, screenHeight);
		 rec1.setFill(Color.RED);
		 
		 root.getChildren().add(rec1);
		 
		
		stage.setResizable(false);
		stage.setTitle("Super Game");
		stage.setScene(scene);
		stage.show();
		
		startGameThread(stage);
		
	}
	
	public void startGameThread(Stage stage, Pane root) {
		Task task = new Task<Void>() {
		    @Override public Void call() {
		    	while(true) {
		   		 Rectangle rec1 = new Rectangle(screenWidth, screenHeight);
				 rec1.setFill(Color.RED);
				 
				 root.getChildren().add(rec1);
		    		
		    	}
		    	
		    }
		};
		gameThread = new Thread(task);
		gameThread.run();
	}

	@Override
	public void run() {
		while(gameThread != null) {
			
			System.out.println("The game is running");
		}
		
	}
	
	public static void main (String [] args ) {
		
		launch(args);
	}
	
	
	
}
