

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.stage.Stage;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.text.Font;

import javafx.scene.layout.VBox;


public class TextAdventure extends Application {

	private TextArea output = new TextArea();
	
	private TextField input = new TextField();
	
	private Map<String, Command> commands = new HashMap<>();
	
	int Qrooms = 3;
	
	private Room[][] rooms = new Room[Qrooms][Qrooms];
	
	
	private Parent createContent() {
		
		output.setPrefHeight(600);
		output.setFont(Font.font(25));
		output.setEditable(false);
		
		output.setFocusTraversable(false);
		
		input.requestFocus();
		
		input.setOnAction(e -> {
			String inputText = input.getText();
			input.clear();
			
			onInput(inputText);
		});
		
		
		VBox root = new VBox(15, output, input);
		root.setPadding(new Insets(15));
		root.setPrefSize(800,600);
		
		initGame();
		
		return root;
	}
	
	
	private void initGame() {
		println("welcome to the game");
		initCommands();
		initRooms();
		
	}
	
	private void initCommands() {
		
			commands.put("quit", new Command("quit", "quit the game", () -> Platform.exit()));
			commands.put("help", new Command("help", "Print all the commands", () -> helpCommand()));
			
			commands.put("save", new Command("get", "get an element", () -> saveCommand()));
			commands.put("restore", new Command("get", "get an element", () -> restoreCommand()));
			commands.put("go east", new Command("go east", "go to east", () -> goCommand(1,0)));
			commands.put("go west", new Command("go west", "go to east", () -> goCommand(-1,0)));
			commands.put("go north", new Command("go north", "go to east", () -> goCommand(0,1)));
			commands.put("go south", new Command("go south", "go to east", () -> goCommand(0,-1)));
			commands.put("attack", new Command("attack", "kill the monster", () -> attackCommand()));
			
			
//			commands.put("get", new Command("get", "get an element", () -> getCommand()));
//			commands.put("drop", new Command("drop", "drop an element", () -> dropCommand()));		
//			
//			commands.put("look", new Command("get", "get an element", () -> lookCommand()));	
//			commands.put("inventory", new Command("get", "get an element", () -> inventoryCommand()));
//			


			//			commands.put("exit", new Command("exit", "Exit the game", () -> Platform.exit()));
//			commands.put("exit", new Command("exit", "Exit the game", () -> Platform.exit()));

	
	}

	private void initRooms() {
		
		for (int i = 0; i < Qrooms ; i++) {
			for (int y = 0; i < Qrooms ; y++) {
					
				if (y % 2 == 0 ) {
					rooms[i][y].spawnMonsters();
				} else if (i % 2 == 0 ) {
					rooms[i][y].spawnMonsters();
					rooms[i][y].setDark();
					
				} 
			}
	}
	}

	private void println(String line) {
		output.appendText(line + "\n");
	}
	

	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.show();

		
	}
	
	public static class Launcher {
		
		public static void main(String [] args ) {
			Application.launch(TextAdventure.class, args);
		}
	}
	
	private void onInput(String line) {
		if(!commands.containsKey(line)) {
			println("Command " + line + " not found");
			return;
		}
		commands.get(line).execute();
		
	}
	
	private void saveCommand() {
			
		println("Game saved");
	}
	private void restoreCommand() {
		
		println("Game restored");
	}
	
	private void helpCommand() {
		commands.forEach(( name, command) -> {			
			println(name + "\t" + command.getDescription()); // need tp format				
		});
		
	}
	private void goCommand(int x, int y) {
		println("Moving by " + x + " " + y );
		
	}
	
	private void attackCommand() {
		
	}
	
	
}
