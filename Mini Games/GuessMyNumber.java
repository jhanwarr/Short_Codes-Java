import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessMyNumber
{
    public final static int MAX_GUESSES = 7;
    //constant for the number of guesses allowed, depending on the range of numbers possible

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader instead of Scanner because of multiple String inputs

        System.out.print("Please enter your name : ");
        String name = br.readLine();
        int count_wins = 0, count_rounds = 0;
        //storing the wins of the player and rounds played for

        System.out.println("Hi "+name+"!");

        for(;;) //Here starts infinite loop which breaks only after user want's it to
        {
            count_rounds++; //UPDATING the round 

            int num = (int)(Math.random() * 100) + 1;
            //generating different random numbers for different rounds
            int guesses = 0, g = 0;

            System.out.println("You have 7 tries to guess the number I have in mind (between 1 to 100).\n");
            //Prinintg the instructions 

            boolean won = false;

            inner:
                while(guesses < MAX_GUESSES) //Individual Rounds start here
                {
                    System.out.println("\nYou have "+(MAX_GUESSES - guesses)+" tries left.");
                    System.out.print("Please enter your guess : ");

                    //A try catch block is used to give the user another chance if wrong type of input is entered
                    try
                    {
                        g = Integer.parseInt(br.readLine()); 
                    }

                    catch(NumberFormatException e) //If anything but an integer is inputted, an exception would be generated
                    {
                        System.err.println("\nAn integer is expected as an input."); //printing in the error console
                        System.out.print("Please enter an integer only : ");
                        g = Integer.parseInt(br.readLine()); //Second chance for the user
                    }

                    guesses++; //UPDATING guesses with a suucessfull input

                    if(g<1 || g>100)
                        System.out.println("A gentle reminder that the number is between 1 to 100");
                    //Reminding the user of the number range

                    else if(g == num)
                    {
                        System.out.println("Hurrah! You gussed the number in "+guesses+" tries!!!");
                        won = true; //UPDATING won here
                        break inner;
                    }

                    else if(g < num)
                        System.out.println("Your guessed number is smaller than the number I have in mind.");

                    else
                        System.out.println("Your guessed number is bigger than the number I have in mind.");
                }

            if(won)
                count_wins++; //UPDATING win count here

            else
            {
                System.out.println("Oops, you could not guess the number in 7 tries.");
                System.out.println("The number was : "+num+". Better luck next time. ");
            }

            System.out.println("\n\nDo you want to play again?"); //Asking for another game here
            System.out.print("Enter yes or no : ");
            String s = br.readLine().toLowerCase();

            if(s.equals("no")) //block to print the statistics and exit the code
            {
                System.out.println("\n\nStatitics -– \n");

                System.out.println("Rounds –  "+count_rounds);
                System.out.println(" Wins  –  "+count_wins);

                System.out.println("\nWin Percentage – "+((count_wins/count_rounds)*100)+"%");

                System.out.println("\n\nThank you so much! I hope you enjoyed.");

                br.close(); //closing the BufferedReader object before exitting the code
                System.exit(0); //exitting the code with no errors in the program
            }

            else if(!s.equals("yes"))
            {
                System.out.println("Invalid input received. Exitting the code. \nI hope you enjoyed the game!");
                br.close(); //closing the BufferedReader object before exitting the code
                System.exit(0); //exitting the code with no errors in the program
            }
        }

        br.close(); //closing the BufferedReader object before exitting the code
    }
}
