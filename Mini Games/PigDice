import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PigDice
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int p1 = 0, p2 = 0; //player scores
		boolean p1check = true; //boolean to check whether it is player 1's chance or not
		
		int round = 1, turn = 0, roll = 0; //the round number, a player's score in the current turn, and number rolled 
		
		
		System.out.println("Welcome to Pig Die game! ");
		System.out.println("The aim is to roll a die and score 100 points without using 1 in your score.");
		System.out.println("Moreover, rolling one would lead to a change in the chance between players.\n");
		//Information on playing the game
		Thread.sleep(1500); //pause of 1.5 seconds after info, 0.5 after each turn, 1.5 after change in players' turn
		
		while(check(p1, p2, turn, p1check))
		{
			boolean invalid = true; //boolean for checking the input validation
			
			System.out.println("\n");
			System.out.println("It's player "+(p1check ? 1 : 2)+"'s turn.");
			
			System.out.print("Please enter 'roll' or 'stop' : ");
			String choice = br.readLine().toLowerCase();
			
			if(choice.equals("roll"))
			{
				roll = rollDie(); //random number between 1 to 6 (both inclusive)
				System.out.println("\nYou rolled a "+roll);
				turn += roll;				
				invalid = false;
			}
			
			if( (choice.equals("stop")) || (roll == 1) ) //conditions for switching players 
			{
				if(p1check && (roll != 1)) 
					p1+=turn;
				
				if(!p1check && (roll != 1))
					p2+=turn;

				//1 - Score Addition 


				scorecard(p1, p2, round);
				Thread.sleep(1500);
				//pause of 1.5 seconds after info, 0.5 after each turn, 1.5 after change in players' turn

				
				p1check = !p1check; //2 - Switching player
				turn = 0;
				
				if(!p1check)
					round++;

				//3 - Round incrementation
				
				continue;
			}
			
			if(invalid)
			{
				//input validation
				System.out.println("Invalid option entered. Please enter from the options provided.");
				continue;
			}
			
			System.out.println("The turn total is : "+turn);
			Thread.sleep(500);
			//pause of 1.5 seconds after info, 0.5 after each turn, 1.5 after change in players' turn
			
		}
		

		//Checking and printing the winner between Player 1 and 2
		if(p1check)
		{
			p1 += turn;
			System.out.print("\n\nWoah! Player 1 ");
		}
		
		else
		{
			p2 += turn;
			System.out.print("\n\n Woah! Player 2 ");
		}
		
		System.out.println("wins with a margin of "+Math.abs(p1-p2)+" points!");
	}
	
	
	/**
	 * Checking whether we have a winner or not
	 * @param p1 Player 1's score
	 * @param p2 Player 2's score
	 * @param turn The score in the current turn
	 * @param p1check The current player
	 * @return Whether we have a winner (true) for the game or not (false)
	 */
	public static boolean check(int p1, int p2, int turn, boolean p1check)
	{
		if(p1check)
		{
			if((p1 + turn) > 100)
				return false;
		}
		
		else
		{
			if((p2 + turn) > 100)
				return false;
		}
		
		return true;
	}
	
	/**
	 * Printing the scorecard of the players
	 * @param p1 Player 1's score
	 * @param p2 Player 2's score
	 * @param round The current round number
	 */
	public static void scorecard(int p1, int p2, int round)
	{
		System.out.println("\f");
		System.out.println("Scorecard for Round "+round+" ––>\n");
		
		System.out.println("Player 1  --  "+p1);
		System.out.println("Player 2  --  "+p2);
		
		System.out.println("\n\n");
	}
	
	/**
	 * Simulating the function of a die 
	 * @return any number between 1 and 6 (both inclusive)
	 */
	public static int rollDie ()
	{
		return (int)(Math.random () * 6) + 1;
	}
}
