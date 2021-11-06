import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.animation.PauseTransition;


public class JavaFXTemplate extends Application {
	Button b1;
	Button drawb;
	Button newGameb;
	Button randb;

	static Text t1;
	static Text t2;
	Text t3;
	Text t4;
	private static Text info;
	int index;


	Label instruct;
	Label Drawn;
	Label Matched;
	Label win, space1, space2, space3;
	Label welcome;

	static MenuBar menu;
	private static MenuBar menu2; //displays the number of spots the user can play
	private static MenuBar menu3; //displays the number of drawings the user can play
	
	static HashMap<String, Scene> sceneMap;

	GridPane grid;
	private static EventHandler<ActionEvent> myHandler;
	
	
	private static Image chance;
	private static Image odds;
	private static Image rules;
	
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	
	BorderPane borderPane;
	BorderPane intialPane;
	BorderPane displayOdds;
	BorderPane displayRules;
	
	int[] totalWon = {0}; //total won since the game started
	int[] count = {0}; // the number of spots the user selected off the grid
    int[] countdraw = {0}; //the current draw number
    int[] numArr = {0}; //holds the number spots the user is playing
    int[] numDraw = {0}; //holds the number of draws the user selected
    int[] wontot = {0}; //amount the user won since the start of the game
    
    ArrayList<Integer> numChosen = new ArrayList<Integer>(); // list of numbers selected by user on grid
    ArrayList<Integer> rndArr = new ArrayList<Integer>(); // list of 80 numbers
	ArrayList<Integer> numDrawn = new ArrayList<Integer>(); // random 20 numbers out of 80
	ArrayList<Integer> numMatched = new ArrayList<Integer>(); // list of numbers which the picked that match with the draw

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		launch(args);
	}

	
	//WELCOME WINDOW
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
				
		t1 = new Text();
		t2 = new Text();
		t3 = new Text();
		t4 = new Text();
		welcome = new Label();
		info = new Text();
		win = new Label("WIN INFO:");
		instruct = new Label("INSTRUCTIONS:");
		Drawn = new Label("NUMBERS DRAWN:");
		Matched = new Label("NUMBERS MATCHED:");
		space1 = new Label(" ");
		space2 = new Label(" ");
		space3 = new Label(" ");

		grid = new GridPane();
		
		// Add Title and icon for the game
		primaryStage.setTitle("Welcome to Keno!");
		Image ico = new Image("https://image.flaticon.com/icons/png/512/2102/2102252.png");
		primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(ico);
        sceneMap = new HashMap<String, Scene>();
       
        // START GAME BUTTON
		b1 = new Button("START GAME");
		b1. setOnAction(e-> {      
			SecondStage().show(); // when user clicks "START GAME" second window opens
			primaryStage.close(); // close welcome window
		});
		
		
		BorderPane borderPane = new BorderPane();
		BorderPane displayOdds = new BorderPane();
		BorderPane displayRules = new BorderPane();
		
		//Initialize Images
		chance = new Image("https://nclottery.com/content/images/KenoPlaySlip2020.jpg");
		odds = new Image("https://nclottery.com/content/images/KenoPrizeChart2020.jpg");
//		odds = new Image("odds.jpg");
		rules = new Image("kenorules.png");
		
		//Initialize ImageView
		imageView1 = new ImageView(chance);
		imageView2 = new ImageView(odds);
		imageView3 = new ImageView(rules);
		
		//Initialize ImageView Size
		imageView1.setFitHeight(685);
		imageView1.setFitWidth(300);
		imageView1.setPreserveRatio(true);
		imageView2.setFitHeight(500);
		imageView2.setFitWidth(400);
		imageView2.setPreserveRatio(false);
		imageView3.setFitHeight(975);
		imageView3.setFitWidth(975);
		imageView3.setPreserveRatio(true);
		
		// IMAGES TO SHOW ODDS
		displayOdds.setStyle( "-fx-background-image: url(" +
                "'https://lh3.googleusercontent.com/yw7Y7vidKLuVvYGEolEcheo36KnJeV4zksjxXD6mSueZJOeS8RdCOu6EwuJqVrtdIwI'" +
            "); " +
            "-fx-background-size: cover;");
		displayOdds.setLeft(imageView1);
		displayOdds.setCenter(imageView2);
		
		// IMAGES TO SHOW RULES
		displayRules.setStyle( "-fx-background-image: url(" +
                "'https://lh3.googleusercontent.com/yw7Y7vidKLuVvYGEolEcheo36KnJeV4zksjxXD6mSueZJOeS8RdCOu6EwuJqVrtdIwI'" +
            "); " +
            "-fx-background-size: cover;");
		
		displayRules.setCenter(imageView3);
		
		Scene rules = new Scene(displayRules);
		Scene odds = new Scene(displayOdds);
		
		sceneMap.put("rules", rules);
		sceneMap.put("odds", odds);
		
   // WELCOME MENU
		menu = new MenuBar();
		menu.prefWidthProperty().bind(primaryStage.widthProperty());
		menu.setStyle("-fx-font-size:28;" + "-fx-background-color: blue;" + "-fx-text-fill: red;");
		b1.setStyle("-fx-border-color: red;"+ "-fx-border-width: 10;"+ "-fx-background-color: #0703E1;" + "-fx-text-fill: red;");
		
		Menu mOne = new Menu("Menu");
		
		MenuItem iOne = new MenuItem("Play Game");
		iOne.setOnAction(e->{ 
							  borderPane.setTop(menu);
							  primaryStage.setScene(sceneMap.get("main"));}); //return to welcome menu
		mOne.getItems().add(iOne);
		
		MenuItem iTwo = new MenuItem("Display Rules");
		iTwo.setOnAction(e->{
			displayRules.setTop(menu);
			//Scene rules = new Scene(displayRules);
			primaryStage.setScene(sceneMap.get("rules"));
			}); //add rules
		mOne.getItems().add(iTwo);		
		
		MenuItem iThree = new MenuItem("Display Odds");
		iThree.setOnAction(e->{
			displayOdds.setTop(menu);
			//Scene odds = new Scene(displayOdds);
			primaryStage.setScene(sceneMap.get("odds"));
			}); //add Odds
		mOne.getItems().add(iThree);
		
		MenuItem iFour = new MenuItem("Exit Game");
		iFour.setOnAction(e -> Platform.exit());
		mOne.getItems().add(iFour);
		
		menu.getMenus().addAll(mOne); // adds all three options(iOne,iTwo,iThree, ifour) to one menu
	

  //CODE FOR LAYOUT OF WELCOM SCREEN
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		

		HBox hbox1 = new HBox(menu); //holds all the menus
		
		//BorderPane borderPane = new BorderPane();
		borderPane.setTop(hbox1); //display menus at the top
		borderPane.setCenter(b1);//start button


		Scene scene = new Scene(borderPane);
		sceneMap.put("main", scene);
		
		borderPane.setStyle( "-fx-background-image: url(" +
                "'https://lh3.googleusercontent.com/yw7Y7vidKLuVvYGEolEcheo36KnJeV4zksjxXD6mSueZJOeS8RdCOu6EwuJqVrtdIwI'" +
            "); " +
            "-fx-background-size: cover;");

		primaryStage.setScene(scene);
		primaryStage.show();
		
		} // end of welcome window

		//method to create the grid for the second window
		public static void addGrid(GridPane grid) 
		{
			int num = 0;
			for(int x = 3; x<11; x++) 
			{
				for(int i = 3; i<13; i++) 
				{
					num = num +1;
					Button b1 = new Button(Integer.toString(num));
					b1.setOnAction(myHandler);
					b1.setStyle("-fx-base: # f2f2f2");
					grid.add(b1, i, x);	 
				}
			}
		}

///////////////////////////////////////////////////////////////////////////////////////CODE FOR GAME WINDOW 
	    // game window
		@SuppressWarnings("deprecation")
		public Stage SecondStage() {
	    	
	    	Stage secondStage = new Stage(); //creating new window
	    	
	    	BorderPane borderPane = new BorderPane(); //for scene layout
	    	borderPane.setStyle( "-fx-background-image: url(" +
	                "'https://pressstart.vip/images/uploads/assets/bluemoon.png'" +
	            "); " +
	            "-fx-background-size: cover;");
	    	
//MENUS ALLOWING THE USER TO PICK NUMBER OF SPOTS AND DRAWINGS
			
			//Menu to pick the number of spots the user wants to play
			Menu x = new Menu("Choose spots to play");
			
			MenuItem i1 = new MenuItem("1");
			i1.setOnAction(e->{
				info.setText("Play 1 spot, now choose the number of draws from the 'Pick drawing' menu on top");
				   numArr[0] = 1; 
			});
			x.getItems().add(i1);		
			
			MenuItem i2 = new MenuItem("4");
			i2.setOnAction(e->{
				info.setText("Play 4 spots, now choose the number of draws from the 'Pick drawing' menu on top");
				   numArr[0] = 4;
			});
			x.getItems().add(i2);
			
			MenuItem i3 = new MenuItem("8");
			i3.setOnAction(e->{
				info.setText("Play 8 spots, now choose the number of draws from the 'Pick drawing' menu on top");
				   numArr[0] = 8;
			});
			x.getItems().add(i3);
			
			MenuItem i4 = new MenuItem("10");
			i4.setOnAction(e->{
				info.setText("Play 10 spots, now choose the number of draws from the 'Pick drawing' menu on top");
				   numArr[0] = 10;
			});; 
			x.getItems().add(i4);
			
			menu2 = new MenuBar();
			menu2.getMenus().addAll(x); //adds all 4 options(1,2,8 or 10 spots) to one menu
					
			
			//Menu to pick the number of drawings the user wants to play
			Menu x2 = new Menu("Pick drawing");
			
			MenuItem One = new MenuItem("1");
			One.setOnAction(e->{
		        	numDraw[0] = 1;
		        	info.setText("Select your numbers or click 'RANDOM' to have the numbers selected for you, then click 'DRAW' to draw 20 numbers");
		        	if(numArr[0] != 0)
		        		grid.setDisable(false);
	        		menu2.setVisible(false); //not allowing the user to change the number of spots to play once the game starts
	        		randb.setDisable(false);
				});
			x2.getItems().add(One);		
			
			MenuItem Two = new MenuItem("2");
			Two.setOnAction(e->{
	        	numDraw[0] = 2;
	        	info.setText("Select your numbers or click 'RANDOM' to have the numbers selected for you, then click 'DRAW' to draw 20 numbers");
	        	if(numArr[0] != 0)
	        		grid.setDisable(false);
        		menu2.setVisible(false); //not allowing the user to change the number of spots to play once the game starts
        		randb.setDisable(false);
        		
				});
			x2.getItems().add(Two);
			
			MenuItem Three = new MenuItem("3");
			Three.setOnAction(e->{
	        	numDraw[0] = 3;
	        	info.setText("Select your numbers or click 'RANDOM' to have the numbers selected for you, then click 'DRAW' to draw 20 numbers");
	        	if(numArr[0] != 0)
	        		grid.setDisable(false);
        		menu2.setVisible(false); //not allowing the user to change the number of spots to play once the game starts
        		randb.setDisable(false);

				});
			x2.getItems().add(Three);
			
			MenuItem Four = new MenuItem("4");
			Four.setOnAction(e->{
	        	numDraw[0] = 4;
	        	info.setText("Select your numbers or click 'RANDOM' to have the numbers selected for you, then click 'DRAW' to draw 20 numbers");
	        	if(numArr[0] != 0)
	        		grid.setDisable(false);
        		menu2.setVisible(false); //not allowing the user to change the number of spots to play once the game starts
        		randb.setDisable(false);

				}); 
			x2.getItems().add(Four);
			
			menu3 = new MenuBar();
			menu3.getMenus().addAll(x2); //adds all 4 options(1,2,3 or 4 drawings) to one menu
	    	
	    	menu.getMenus().clear();
	    	menu.setStyle("-fx-font-size:28;" + "-fx-background-color: blue;" + "-fx-text-fill: red;");
	    	menu = new MenuBar();
			
	    	// welcome menu edited to include new look
	    	// Reset the Menu
	    	menu.getMenus().clear();

	    	Menu mOne = new Menu("Menu");
			
			MenuItem iOne = new MenuItem("Display Rules");
			
			iOne.setOnAction(e->{      
				ThirdStage().show(); 
			});
			mOne.getItems().add(iOne);		
			
			MenuItem iTwo = new MenuItem("Display Odds");
			iTwo.setOnAction(e->{      
				FourthStage().show(); 
			});
				
			mOne.getItems().add(iTwo);
			
			MenuItem iThree = new MenuItem("Exit Game");
			iThree.setOnAction(e -> Platform.exit()); // exits the application
			mOne.getItems().add(iThree);
			
			MenuItem ifour = new MenuItem("New look");
			ifour.setOnAction(e->{
							  borderPane.setStyle( "-fx-background-image: url(" +
						                "'https://www.law.washington.edu/images/zoom/Lasers-Background.jpg'" +
						            "); " +
						            "-fx-background-size: cover;");
							menu.setStyle("-fx-background-color: purple;" + "-fx-text-fill: red;");
							x.setStyle("-fx-background-color: purple;" + "-fx-text-fill: red;");
							x2.setStyle("-fx-background-color: purple;" + "-fx-text-fill: red;");
							Matched.setTextFill(Color.web("#DC143C"));
							Drawn.setTextFill(Color.web("#DC143C"));
							instruct.setTextFill(Color.web("#DC143C"));
							info.setFill(Color.web("#DC143C"));
							win.setTextFill(Color.web("#DC143C"));
							t1.setFill(Color.web("#DC143C"));
							t2.setFill(Color.web("#DC143C"));
							t3.setFill(Color.web("#DC143C"));
							t4.setFill(Color.web("#DC143C"));
							Matched.setStyle("-fx-font-weight: bold");
							Drawn.setStyle("-fx-font-weight: bold");
							instruct.setStyle("-fx-font-weight: bold");
							info.setStyle("-fx-font-weight: bold");
							win.setStyle("-fx-font-weight: bold");
							t1.setStyle("-fx-font-weight: bold");
							t2.setStyle("-fx-font-weight: bold");
							t3.setStyle("-fx-font-weight: bold");
							t4.setStyle("-fx-font-weight: bold");
				
			});
			mOne.getItems().add(ifour);		
			menu.getMenus().addAll(mOne); // adds all three options(iOne,iTwo,iThree) to one menu			
/////////// end of menu code
		
	      
//Event handler attached to each button in the GridPane
			myHandler = new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e) {
					randb.setDisable(true);
					System.out.println("button pressed: " + ((Button)e.getSource()).getText()); //output what button was pressed
					index = 0;
					
					Button b = (Button)e.getSource();
					//allowing the user to unselect a number they already selected 
					KenoLogic.buttonClicked(e,b,numChosen,index,count);
					System.out.println("count " + Integer.toString(count[0]));
					if(count[0] == numArr[0]) //if the user selected the all the spots they chose to play
					{
						KenoLogic.noSpotsLeft(numChosen,grid,drawb,info);
					}
					info.setText("You have " + Integer.toString(numArr[0]-count[0])  + " spots avaible");
				}
			};
			      
///////GRID SETUP
			grid.setAlignment(Pos.CENTER); 
			addGrid(grid); //populate the GridPane with buttons
			grid.setDisable(true); //Initially disable the grid		
			info.setText("Choose the number of spots to play using the 'Choose spots to play' menu on top");
			t2.setText(" "); //Initially making all text blank and buttons disabled
			t3.setText("");
			t4.setText("");
			newGameb = new Button("START NEW GAME");
			newGameb.setDisable(true);
			randb = new Button("Random"); //computer choose 20 numbers for you
			randb.setDisable(true);

//Event handler for 'RANDOM' button, which chooses grid numbers for users
			EventHandler<ActionEvent> myHandler4 = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent y) 
				{
					menu3.setVisible(false); //not allowing the user to change the number of draws once the game starts
					rndArr.clear(); numChosen.clear();
					t1.setText(""); t2.setText("");
					grid.setDisable(true); //Initially disable the grid		

					rndArr = KenoLogic.randArr_80(rndArr); //generate list of 80 numbers randomly
					numChosen = KenoLogic.picksForUser(rndArr,numChosen,numArr[0]); // pick numbers of grid for user
					
					drawb.setDisable(false); 
					randb.setDisable(true); 
					info.setText("No more spots avaible, click 'DRAW' to view drawings");
				}
			};
			
			randb.setOnAction(myHandler4);
			
//Event handler for 'DRAW' button
			EventHandler<ActionEvent> myHandler2 = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent y) {
				
						//reset 
						numMatched.clear();	numDrawn.clear(); 	rndArr.clear();
						drawb.setDisable(true); // disable draw button
						randb.setDisable(true); // disable random button
						menu3.setVisible(false); //not allowing the user to change the number of draws once the game starts
						grid.setDisable(true); //Initially disable the grid	
						info.setText("Drawing numbers, diplayed below");
						
						//increment the current Draw number
						KenoLogic.updateDarwNumber(countdraw);
						
						//getting a random list with numbers from 1 to 80
						KenoLogic.randArr_80(rndArr);
						
						 KenoLogic.dispDrawnNubers(rndArr,drawb,newGameb,numDraw,numDrawn,countdraw,t1);

						//creating a list of numbers that matched from the current draw
						 KenoLogic.numbersMatached(numChosen,numMatched,numDrawn);
					
						//displaying the numbers that matched one after another
						KenoLogic.dispMatchednum(numMatched, t2);

						//calculating how much money the user won this draw
						KenoLogic.moneyWon(numArr, wontot, numMatched);
						
						//update total money won since game started
						KenoLogic.updateTotalWon(totalWon,wontot);
						t4.setText("Won since game started: $" + totalWon[0]);
	
						KenoLogic.check4RemainingDraws(countdraw, numDraw, numMatched, wontot, info, t3);			
				}
			};
			
//Event Handler for 'STARTING NEW GAME' button
			EventHandler<ActionEvent> myHandler3 = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent y) 
				{
					//clearing old grid
					grid.setGridLinesVisible(false);
					grid.getColumnConstraints().clear();
					grid.getRowConstraints().clear();
					grid.getChildren().clear();
					grid.setGridLinesVisible(true);
					
					addGrid(grid); // adding new grid
					
					// resetting all elements
					newGameb.setDisable(true); 	menu2.setVisible(true); menu3.setVisible(true); 
					info.setText("1st choose the number of spots to play then choose the number of draws");
					t1.setText(" "); t2.setText(" "); t3.setText("");
			        numChosen.clear(); 	numMatched.clear(); numDrawn.clear();
					rndArr.clear();

					wontot[0] = 0;	count[0] = 0;  countdraw[0] = 0;  
					numArr[0] = 0; numDraw[0] = 0; 
			        
					grid.setDisable(true); //Initially disable the grid	
				}
	
			};

			newGameb.setOnAction(myHandler3);// startbutton
			drawb = new Button("DRAW"); // allows the next draw to begin
			drawb.setDisable(true);
			drawb.setOnAction(myHandler2);

//CODE FOR DISPLAYING GAME WINDOW	
			
			// Add title for game
	    	secondStage.setTitle("Good Luck!");
	        Image ico = new Image("https://image.flaticon.com/icons/png/512/2102/2102252.png");
	        secondStage.getIcons().add(ico);
	        secondStage.initStyle(StageStyle.UNDECORATED);
			
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();

	        //set Stage boundaries to visible bounds of the main screen
			secondStage.setX(bounds.getMinX());
			secondStage.setY(bounds.getMinY());
			secondStage.setWidth(bounds.getWidth());
			secondStage.setHeight(bounds.getHeight());
			
			
			VBox vbox2 = new VBox(2,drawb,newGameb,randb);
			VBox vbox = new VBox(2,instruct,info,space1,Drawn,t1,space2,Matched,t2,space3,win,t3,t4); //holds all the text boxes
			HBox hbox = new HBox(menu,menu2,menu3); //holds all the menus
			
			hbox.setStyle("-fx-background-color: lightblue;");
			
			borderPane.setStyle( "-fx-background-image: url(" +
	                "'https://pressstart.vip/images/uploads/assets/bluemoon.png'" +
	            "); " +
	            "-fx-background-size: cover;");
			borderPane.setTop(hbox); //display menus at the top
			borderPane.setCenter(grid);
			borderPane.setRight(vbox2);//draw button
			borderPane.setBottom(vbox); //display text boxes at the bottom
	
			Scene scene = new Scene(borderPane,700,700);
			secondStage.setScene(scene);
	        return secondStage;
	        
	    }// end of second stage/game window


// stage to display rules
		public Stage ThirdStage() {
			Stage ThirdStage = new Stage(); //creating new window
			
			
			welcome.setText("RULES: \n" + "1. Decide how much to play per draw. Each play costs $1. Play for $2 to double your prize;\n" +"play for $3 to triple your prize and so on up to $10 per play.\n" + 
					"\n2. Select how many consecutive draws to play. Pick up to 20. Drawings happen every 4 minutes.\n" + 
					"\n3. Select how many numbers to match from 1 to 10. In Keno, these are called Spots.\n"+"The number of Spots you choose and the amount you play per draw will determine the amount you could win.\n" + "See the prize chart to determine the amount you could win with a $1 play.\n" + 
					"\n4.Pick as many numbers as you did Spots. You can select numbers from 1 to 80\n" + " or choose Quick Pick and let the computer terminal randomly pick some or all of these numbers for you.\n" + 
					"\n5.Add Multiplier to increase all prizes up to 10X. Multiplier doubles base ticket cost. "); //add rules
					
			BorderPane borderPane1 = new BorderPane();
			borderPane1.setCenter(welcome);
			Scene scene = new Scene(borderPane1,700,700);
			ThirdStage.setScene(scene);
			ThirdStage.show();
			
			return ThirdStage;
		}
		
// stage to display oods
		public Stage FourthStage() {
			Stage FourthStage = new Stage(); //creating new window
			
			welcome.setText("ODDS: \n" + "Approximate overall odds to win a prize range from 1 in 3.86 to 16.63 \n"
					+ "Approximate odds to win the top prize on the 10 Spot game are 1 in 8.91 million\n "
					+ "Overall odds of receiving a multiplier 2X or higher are 1 in 1.67.");
					
			BorderPane borderPane1 = new BorderPane();
			borderPane1.setCenter(welcome);
			Scene scene = new Scene(borderPane1,700,700);
			FourthStage.setScene(scene);
			FourthStage.show();
			
			return FourthStage;
		}

}

