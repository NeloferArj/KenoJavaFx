import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class KenoLogic {
	
	static String temp = ""; // will hold the numbers drawn
	static String temp2 = ""; // will hold the numbers matched
	
	
	public static int buttonClickedHelper(int[] count,int add)
	{

		count[0] = count[0] + add; //decrease the total numbers selected

		int val = count[0];
		return val;
	}
	
	@SuppressWarnings("deprecation")
	public static void buttonClicked(ActionEvent e,Button b, ArrayList<Integer> numChosen, int index,int[] count)
	{
	
		//allowing the user to unselect a number they already selected 
		if(numChosen.contains(Integer.parseInt(((Button)e.getSource()).getText()))) //checking if the number pressed was already selected before
		{
			index = numChosen.lastIndexOf(Integer.parseInt(((Button)e.getSource()).getText())); //get the index of where the selected number is stored in the list
			numChosen.remove(index); //remove the selected number
			count[0] = buttonClickedHelper(count,-1); //decrease count
			b.setStyle("-fx-base: # f2f2f2"); // change color back to default
		}
		else
		{	//this number was not selected before, add it to the list
			numChosen.add(new Integer(Integer.parseInt(((Button)e.getSource()).getText())));
			count[0] = buttonClickedHelper(count,1); //increase count
			b.setStyle("-fx-base: red"); // change color to red to show it has been selected

		}
	}
	
	public static void noSpotsLeft(ArrayList<Integer>numChosen,GridPane grid, Button drawb, Text info)
	{
		System.out.println("Actual list");
		for(int i=0; i<numChosen.size(); i++)
		{
			System.out.println(numChosen.get(i));
		}

		grid.setDisable(true); // disable grid
		drawb.setDisable(false); 
		info.setText("No more spots avaible, click DRAW to view drawings");

	}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<Integer> randArr_80(ArrayList<Integer> rndArr)
	{
		for(int i =1; i<=80; i++)
		{
			rndArr.add(new Integer(i)); //creating of list with numbers from 1 to 80
		}
		Collections.shuffle(rndArr); //shuffle the list of 80 numbers
		return rndArr;
	}
	
	
	
	@SuppressWarnings("deprecation")
	public static ArrayList<Integer> picksForUser(ArrayList<Integer> rndArr, ArrayList<Integer> numChosen, int i) {
		for(int j =0; j<i; j++) 
		{
			final int numz = j;
			numChosen.add(new Integer(rndArr.get(numz))); //creating a list 20 numbers
			System.out.println("Number Chosen: " +Integer.toString(rndArr.get(numz)));
		}
		return numChosen;
		
	}
	
	@SuppressWarnings("deprecation")
	public static int updateDarwNumber(int[] countdraw) {
		countdraw[0] = countdraw[0]+1; //DRAW was pressed, so increment the current draw number
		System.out.println("Draw Number" + countdraw[0]);
		return countdraw[0];
		
	}
	
	public static void moneyWon(int[] numArr, int[] wontot, ArrayList<Integer> numMatched)
	{
		moneyWonHelper(numArr[0],numMatched.size(),wontot);
	}
	
	public static int moneyWonHelper(int spots, int matched, int[] wontot)
	{
		wontot[0] = 0;
		//calculating how the user won
				if(spots == 1)
				{
					if(matched == 1)
					{
						wontot[0] += wontot[0] + 2; // if you play 1 spot and match 1 spot you win $2
					}
				}
				else if (spots == 4)
				{
					if(matched == 2)
					{
						wontot[0] += wontot[0] + 1; // if you play 2 spot and match 2 spot you win $3
					}
					else if (matched == 3)
					{
						wontot[0] += wontot[0] + 5; // if you play 2 spot and match 3 spot you win $5
					}
					else if (matched== 4) 
					{
						wontot[0] += wontot[0] + 75; // if you play 2 spot and match 4 spot you win $75
					}
				}
				else if (spots == 8)
				{
					if(matched == 4)
					{
						wontot[0] += wontot[0] + 2; // if you play 8 spot and match 4 spot you win $2
					}
					else if (matched == 5)
					{
						wontot[0] += wontot[0] + 12; // if you play 8 spot and match 5 spot you win $12
					}
					else if (matched == 6)
					{
						wontot[0] += wontot[0] + 50; // if you play 8 spot and match 6 spot you win $50
					}
					else if (matched== 7)
					{
						wontot[0] += wontot[0] + 750; // if you play 8 spot and match 7 spot you win $750
					}
					else if (matched == 8)
					{
						wontot[0] += wontot[0] + 10000; // if you play 8 spot and match 8 spot you win $10,000
					}
				}
				else if (spots == 10)
				{
					if(matched == 0)
					{
						wontot[0] += wontot[0] + 5; // if you play 10 spot and match 0 spot you win $5
					}
					else if (matched == 5)
					{
						wontot[0] += wontot[0] + 2; // if you play 10 spot and match 5 spot you win $2
					}
					else if (matched == 6)
					{
						wontot[0] += wontot[0] + 15; // if you play 10 spot and match 6 spot you win $15
					}
					else if (matched == 7)
					{
						wontot[0] += wontot[0] + 40; // if you play 10 spot and match 7 spot you win $40
					}
					else if (matched == 8)
					{
						wontot[0] += wontot[0] + 450; // if you play 10 spot and match 8 spot you win $450
					}
					else if (matched== 9)
					{
						wontot[0] += wontot[0] + 4250; // if you play 10 spot and match 9 spot you win $4250
					}
					else if (matched == 10)
					{
						wontot[0] += wontot[0] + 100000; // if you play 10 spot and match 10 spot you win $100000
					}
				}
				return wontot[0];
	}
	
	public static int updateTotalWon(int[] totalWon, int[] wontot)
	{
		totalWon[0] = totalWon[0] + wontot[0]; // how much the user won since the game started
		return totalWon[0];
	}
			
			
	public static void check4RemainingDraws(int[] countdraw, int[] numDraw, ArrayList<Integer> numMatched, int[] wontot, Text info, Text t3)
	{
		// checking if the user has any draws left, if not the DRAW button is disabled
		if(countdraw[0] == numDraw[0]){
			t3.setText("Matched this drawing: " + numMatched.size()  +  "      Won this drawing: $" + wontot[0]);
			info.setText("No draws left, wait for the draw numbers to finish displaying then click 'START NEW GAME' or exit the game using the menu");
		}
		else{
			t3.setText("Matched this drawing: " + numMatched.size()  +  "      Won this drawing: $" + wontot[0]);
			info.setText("Wait for all draw numbers to finish displaying, then click 'DRAW' to draw 20 more numbers, "+ (numDraw[0]-countdraw[0])+ " draws left");
		}
	}

	public static void dispMatchednum(ArrayList<Integer> numMatched, Text t2)
	{
		temp2 = ""; //initially string is blank
		
		//displaying the numbers that matched one after another
		if(numMatched.size() > 0)
		{				
			System.out.println("Total Numbers Matched:" + numMatched.size());
			for(int j=1; j<=numMatched.size(); j++) 
			{
				final int number = j;
				PauseTransition pause = new PauseTransition(Duration.seconds(j));
				
				System.out.println(numMatched.get(number-1));
				pause.setOnFinished(e->{
					temp2 = temp2 + Integer.toString(numMatched.get(number-1)) + " ";
					t2.setText(temp2);
				});	
				pause.play();
			}
		}
		else
		{
			System.out.println("No numbers Matched");
			t2.setText("NO NUMBERS MATCHED");
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void dispDrawnNubers(ArrayList<Integer> rndArr, Button drawb, Button newGameb, int[] numDraw, ArrayList<Integer> numDrawn, int[] countdraw,Text t1)
	{
		temp = ""; //initially string is blank
		
		for(int j=1; j<=20; j++) 
		{
			final int numz = j;
			PauseTransition pause = new PauseTransition(Duration.seconds(j)); //transition to display the numbers drawn one after another

			numDrawn.add(new Integer(rndArr.get(numz))); //creating a list 20 numbers
			System.out.println("Number Drawn: " +Integer.toString(numDrawn.get(numz-1)));

			pause.setOnFinished(e->{
				temp = temp + Integer.toString(numDrawn.get(numz-1)) + " ";
				t1.setText(temp);
				if(numz == 20 && countdraw[0] != numDraw[0])
				{
					drawb.setDisable(false);				
				}
				if(numz == 20 && countdraw[0] == numDraw[0]){
					{					
						drawb.setDisable(true); // disable draw button
						newGameb.setDisable(false); // show start new game button
					}
				}
			});
			pause.play();
		}
	}

	@SuppressWarnings("deprecation")
	public static void numbersMatached(ArrayList<Integer> numChosen, ArrayList<Integer> numMatched, ArrayList<Integer> numDrawn) 
	{
		for(int x =0; x< 20; x++) 
		{
			if(numChosen.contains(numDrawn.get(x)))
				numMatched.add(new Integer(numDrawn.get(x))); 
		}
		
	}
	
}
