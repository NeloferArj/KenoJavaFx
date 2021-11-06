import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;


import javafx.scene.control.Button;

class MyTest {
	
	static KenoLogic Keno;
	ArrayList<Integer> rndArr;
	ArrayList<Integer> numChosen;
	ArrayList<Integer> numMatched;
	ArrayList<Integer> numDrawn;


	int[] countdraw = {0};
	int[] count = {0};
	int[] wontot = {0}; 	
	int[] totalWon = {0};
	@BeforeEach
 	public void Todo(){
		Keno = new KenoLogic();
		rndArr = new ArrayList<Integer>();
		numChosen = new ArrayList<Integer>();
		numMatched = new ArrayList<Integer>();
		numDrawn = new ArrayList<Integer>();
		
		numDrawn.clear();
		numMatched.clear();
		numChosen.clear();
		rndArr.clear();
		
		rndArr = KenoLogic.randArr_80(rndArr);
		countdraw[0] = 0;
		count[0]= 0;
		wontot[0] = 0;
 	}
	
 	@Test
 	public void test1()
 	{
 		//test if list was populated with 80 number
  		assertEquals(80,rndArr.size(), "Incorrect value");
 	}
 	
 	@Test
 	public void test2()
 	{
 		//test if list was populated 
 		assertNotNull(rndArr,"Array should not be null");
 	}
 	
	@Test
 	@SuppressWarnings("static-access")
	public void test_buttonClickedHelper()
 	{
 		//test if count increases after user clicks on button
 		Keno.buttonClickedHelper(count,0);
 		int val = count[0]+1;
 		int new_val = Keno.buttonClickedHelper(count,1);
 		assertEquals(val,new_val, "count was not incresed");
 	}
	
 	@Test
 	public void test_picksForUser1()
 	{
 		KenoLogic.picksForUser(rndArr, numChosen, 4);
 		assertEquals(4,numChosen.size(), "Incorrect value");
 	}
 	
 	@Test
 	public void test_picksForUser()
 	{
 		//test if list was populated 
 		assertNotNull(numChosen,"Array should not be null");
 	}

 	@Test
 	public void updateDarwNumber()
 	{
 		//test if the current draw number was updated properly 
 		assertEquals(countdraw[0]+1,KenoLogic.updateDarwNumber(countdraw), "Incorrect value");
 	}
 	
 	@Test
 	public void updateDarwNumber2()
 	{
 		//test if current draw number is null  
 		KenoLogic.updateDarwNumber(countdraw);
 		assertNotNull(countdraw, "Count draw should never be null");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper1()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(2,Keno.moneyWonHelper(1,1,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper2()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(1,Keno.moneyWonHelper(4,2,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper3()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(5,Keno.moneyWonHelper(4,3,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper4()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(75,Keno.moneyWonHelper(4,4,wontot), "Incorrect amount won");
 	}
 	
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper5()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(2,Keno.moneyWonHelper(8,4,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper6()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(12,Keno.moneyWonHelper(8,5,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper7()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(50,Keno.moneyWonHelper(8,6,wontot), "Incorrect amount won");
 	}
 	
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper8()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(750,Keno.moneyWonHelper(8,7,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper9()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(10000,Keno.moneyWonHelper(8,8,wontot), "Incorrect amount won");
 	}
 	
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper10()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(5,Keno.moneyWonHelper(10,0,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper11()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(2,Keno.moneyWonHelper(10,5,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper12()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(15,Keno.moneyWonHelper(10,6,wontot), "Incorrect amount won");
 	}
	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper13()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(40,Keno.moneyWonHelper(10,7,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper14()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(450,Keno.moneyWonHelper(10,8,wontot), "Incorrect amount won");
 	}
 	
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper15()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(4250,Keno.moneyWonHelper(10,9,wontot), "Incorrect amount won");
 	}
	 
 	@SuppressWarnings("static-access")
	@Test
 	public void moneyWonHelper16()
 	{
 		//testing if the amount of money the user won in this round is correct
 		assertEquals(100000,Keno.moneyWonHelper(10,10,wontot), "Incorrect amount won");
 	}
 	
 	@Test
 	public void test_moneyWon()
 	{
 		//the amount of money won in the draw should never be null 
 		assertEquals(450,KenoLogic.moneyWonHelper(10,8,wontot), "Incorrect amount won");
 		assertNotNull(wontot,"Array should not be null");
 	}
 	
 	@Test
 	public void test_totalMoneyWon()
 	{
 		//the amount of money won in total should never be null 
 		KenoLogic.updateTotalWon(totalWon, wontot);
 		assertNotNull(totalWon,"Array should not be null");
 		
 	}
 	
 	@Test
 	public void test_totalMoneyWon2()
 	{
 		wontot[0] = 5; totalWon[0] = 3; // if user won 5 dollars this round and won 3 dollars since the game started
 		//test to see if total money won since the game started updates correctly 
 		assertEquals(totalWon[0]+5,KenoLogic.updateTotalWon(totalWon, wontot), "Incorrect value");
 	}
 	
 	@Test
 	public void test_numbersMatched()
 	{
 		numChosen.add(64);
 		numChosen.add(78);
 		numChosen.add(55);
 		numChosen.add(37);
 		
 		numDrawn.add(64);
 		numDrawn.add(78);
 		numDrawn.add(37);
 		numDrawn.add(55);
 		numDrawn.add(1);
 		numDrawn.add(2);
 		numDrawn.add(3);
 		numDrawn.add(4);
 		numDrawn.add(5);
 		numDrawn.add(6);
 		numDrawn.add(7);
 		numDrawn.add(8);
 		numDrawn.add(9);
 		numDrawn.add(10);
 		numDrawn.add(11);
 		numDrawn.add(12);
 		numDrawn.add(13);
 		numDrawn.add(14);
 		numDrawn.add(15);
 		numDrawn.add(16);
 		numMatched.clear();
 		KenoLogic.randArr_80(rndArr);
 		KenoLogic.numbersMatached(numChosen,numMatched,numDrawn);
 		
 		assertEquals(4,numChosen.size(), "Incorrect value");
 		assertEquals(4,numMatched.size(), "Incorrect value");
 		assertEquals(20,numDrawn.size(), "Incorrect value");
 		
 	}
 	
 	@Test
 	public void test_numDrawn()
 	{
 		//Testing if game draws 20 numbers each time
 		KenoLogic.randArr_80(rndArr);
 		numChosen = KenoLogic.picksForUser(rndArr, numChosen, 10);
 		numDrawn = KenoLogic.picksForUser(rndArr, numDrawn, 20);
 		KenoLogic.numbersMatached(numChosen,numMatched,numDrawn);
 		assertEquals(20,numDrawn.size(), "Incorrect value");
 		assertNotNull(numMatched, "Incorrect value");
 		

 	}

 	

 	

}
