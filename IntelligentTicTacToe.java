import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntelligentTicTacToe
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        prints("Welcome to Tic Tac Toe", true, 3000);

        System.out.println("\nOptions – ");
        System.out.println("Enter 1 for 1 player game");
        System.out.println("Enter 2 for 2 player game");
        System.out.println("Enter 3 for Exit\n");

        System.out.print("Please Enter Your Choice : ");
        int ch=Integer.valueOf(br.readLine());

        switch(ch)
        {
            case 1: 
            System.out.println("\f");
            onePlayer();
            break;

            case 2: 
            System.out.println("\f");
            twoPlayers();
            break;

            case 3: 
            System.out.println("\f");
            prints("Thank you.", false, 0);
            prints("Program Developed by Raj Vardhan Jhanwar.", false, 2000);
            System.exit(0);

            default: 
            System.out.println("Wrong choice!!!\n\n\n\n");
            main(args);
            break;
        }
        
        br.close();
    }

    static void onePlayer() throws InterruptedException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Instructions:- ");
        Thread.sleep(1500);
        
        System.out.println("1. This game is controlled entirely by the keyboard.");
        Thread.sleep(2000);
        
        System.out.print("2. To make a move, enter the place where you want to ");
        System.out.println("put in your symbol i.e either a 'X' or an 'C'.");
        Thread.sleep(2000);
        
        System.out.print("3. The layout is shown below with corresponding place ");
        System.out.println("numbers. \n");
        Thread.sleep(2000);
        
        System.out.println("                1 | 2 | 3 ");
        System.out.println("               ---|---|---");
        System.out.println("                4 | 5 | 6 ");
        System.out.println("               ---|---|---");
        System.out.println("                7 | 8 | 9 ");

        prints("\n               Enjoy yourself...\n\n", false, 2000);

        String arr[][] = new String[3][3]; 
        int f = 0, i, j, c = 1;

        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                arr[i][j] = ".";
            }
        }

        System.out.print("Enter your name : ");
        String player = br.readLine();

        for(i=1; i<=9; i++)
        {
            if(c % 2 != 0)
            {
                System.out.println(player+"'s move.");
                enter(arr,c);
                c++;
            }

            display(arr);

            if(hasWon(arr))
            {
                f = 1;
                break;
            }

            if(isFull(arr))
            {
                f = 0;
                break;
            }

            if(c % 2 == 0)
            {
                computersMove(arr);
                display(arr);
                c++;
            }

            if(hasWon(arr))
            {
                f = 2;
                break;
            }

            if(isFull(arr))
            {
                f = 0;
                break;
            }
        }

        String s = "";

        if(f == 0)
            s = "No winner... Game even.";

        else if(f == 1)
            s = "Awesome!!! "+player+" you win!!!";
                    
        else
            s = "Oops!!! The computer wins.";

        prints(s, true, 2000);
        System.out.print("\f");
        br.close();
    }

    static String[][] computersMove(String arr[][])
    {
        int i, j, p=0, k, m, q=0;

        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                if(arr[i][j].equals("X"))
                    p++;

                else if(arr[i][j].equals("C"))
                    q++;
            }

            if(q == 2)
            {
                for(k=0; k<3; k++)
                {
                    if(arr[i][k].equals("."))
                    {
                        arr[i][k] = "C";
                        return arr;
                    }
                }
            }

            q = 0;

            if(p == 2)
            {
                for(k=0; k<3; k++)
                {
                    if(arr[i][k].equals("."))
                    {
                        arr[i][k] = "C";
                        return arr;
                    }
                }
            }

            p = 0;
        }

        p = 0;
        q = 0;

        for(i=0; i<3; i++) //column 
        {
            for(j=0; j<3; j++)
            {
                if(arr[j][i].equals("X"))
                    p++;

                else if(arr[i][j].equals("C"))
                    q++;
            }

            if(q == 2)
            {
                for(k=0; k<3; k++)
                {
                    if(arr[k][i].equals("."))
                    {
                        arr[k][i] = "C";
                        return arr;
                    }
                }
            }

            q = 0;

            if(p == 2)
            {
                for(k=0; k<3; k++)
                {
                    if(arr[k][i].equals("."))
                    {
                        arr[k][i] = "C";
                        return arr;
                    }
                }
            }

            p = 0;
        }

        p = 0;
        q = 0;

        for(i=0; i<3; i++)// right diagonal
        {
            if(arr[i][i].equals("X"))
                p++;

            else if(arr[i][i].equals("C"))
                q++;
        }

        if(q == 2)
        {
            for(j=0; j<3; j++)
            {
                if(arr[j][j].equals("."))
                {
                    arr[j][j] = "C";
                    return arr;
                }
            }
        }

        q = 0;

        if(p == 2)
        {
            for(j=0; j<3; j++)
            {
                if(arr[j][j].equals("."))
                {
                    arr[j][j]="C";
                    return arr;
                }
            }
        }

        p = 0;
        q = 0;

        for(i=0,j=2; j>=0; i++,j--)// left diagonal
        {
            if(arr[i][j].equals("X"))
                p++;

            else if(arr[i][j].equals("C"))
                q++;
        }

        if(q == 2)
        {
            for(k=0,m=2; m>=0; k++,m--)
            {
                if(arr[k][m].equals("."))
                {
                    arr[k][m] = "C";
                    return arr;
                }
            }
        }

        if(p == 2)
        {
            for(k=0,m=2; m>=0; k++,m--)
            {
                if(arr[k][m].equals("."))
                {
                    arr[k][m] = "C";
                    return arr;
                }
            }
        }

        outer: 
        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                if(arr[i][j].equals("."))
                {
                    arr[i][j] = "C";
                    break outer;
                }
            }
        }
        return arr;
    }

    public static void twoPlayers()throws InterruptedException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prints("Instructions:- ",true,2000);

        System.out.println("1. This game is controlled entirely by the keyboard.");
        Thread.sleep(2000);
        System.out.print("2. To make a move, enter the place where you want to ");
        System.out.println("put in your symbol i.e either a 'X' or an 'C'.");
        Thread.sleep(2000);
        System.out.print("3. The layout is shown below with corresponding place ");
        System.out.println("numbers.\n");
        Thread.sleep(2000);

        System.out.println("               1 | 2 | 3 ");
        System.out.println("              ---|---|---");
        System.out.println("               4 | 5 | 6 ");
        System.out.println("              ---|---|---");
        System.out.println("               7 | 8 | 9 ");

        prints("\n               Enjoy yourself...\n\n", false, 0);

        String arr[][] = new String[3][3];
        String p1 = "", p2 = "";
        int i, j, c = 1, f = 0;

        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                arr[i][j] = ".";
            }
        }

        prints("Enter player 1's name : ",false,0);
        p1 = br.readLine();

        prints("Enter player 2's name : ",false,0);
        p2 = br.readLine();

        for(i=0; i<9; i++)
        {
            if(c % 2 != 0)
            {
                System.out.println("\n"+p1+"'s move.");
                enter(arr,c);
                c++;
            }

            display(arr);

            if(hasWon(arr))
            {
                f = 1;
                break;
            }

            if(isFull(arr))
                break;

            if(c%2 == 0)
            {
                System.out.println("\n"+p2+"'s move.");
                enter(arr,c);
                c++;
            }

            display(arr);

            if(hasWon(arr))
            {
                f = 2;
                break;
            }

            if(isFull(arr))
                break;
        }

        System.out.println("\n\nFinal state : ");
        display(arr);

        if(f == 1)
            System.out.println("\n\nCongartulations "+p1+"!!! You win!!!");

        else if(f == 2)
            System.out.println("\n\nCongratulations "+p2+"!!! You win!!!");

        else
            System.out.println("\n\nNo winner. Game even.");

        System.out.print(" Press any key to continue and enter : ");
        br.readLine();
        br.close();
        
        System.out.println("\f");
    }
    
    static String[][] enter(String arr[][], int j)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, f = 0, r = 0, c = 0;

        do
        {
            try
            {
                System.out.print("Where do you want to enter your move? : ");
                i = Integer.parseInt(br.readLine());
                f = 0;
            }
            catch(Exception e)
            {
                f = 1;
            }
        }
        while(f == 1);

        switch(i)
        {
            case 1: 
            r = 0; 
            c = 0;
            break;

            case 2: 
            r = 0; 
            c = 1;
            break;

            case 3: 
            r = 0; 
            c = 2;
            break;

            case 4: 
            r = 1; 
            c = 0;
            break;

            case 5: 
            r = 1; 
            c = 1;
            break;

            case 6: 
            r = 1; 
            c = 2;
            break;

            case 7: 
            r = 2; 
            c = 0;
            break;

            case 8: 
            r = 2; 
            c = 1;
            break;

            case 9: 
            r = 2; 
            c = 2;
            break;

            default :
            System.out.println("Wrong move. Please re-enter.\n");
            enter(arr,j);
            break;
        }

        if(arr[r][c].equals("."))
        {
            if(j % 2 != 0)
                arr[r][c] = "X";

            else
                arr[r][c] = "C";
        }
        else
        {
            System.out.println("Position already filled. Please enter a different position.\n");
            enter(arr,j);
        }

        return arr;
    }
    
    static void display(String arr[][])
    {
        System.out.println("\f");
        System.out.println("                1 | 2 | 3 ");
        System.out.println("               ---|---|---");
        System.out.println("                4 | 5 | 6 ");
        System.out.println("               ---|---|---");
        System.out.println("                7 | 8 | 9 ");
        System.out.println();

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(j != 2)
                {    
                    if(arr[i][j] == ".")
                    {
                        if(i == 0)
                        {
                            if(j == 0)
                                System.out.print("                1 |");

                            else if(j == 1)
                                System.out.print(" 2 |");
                        }

                        else if(i == 1)
                        {
                            if(j == 0)
                                System.out.print("                4 |");

                            else if(j == 1)
                                System.out.print(" 5 |");
                        }

                        else
                        {
                            if(j == 0)
                                System.out.print("                7 |");

                            else if(j == 1)
                                System.out.print(" 8 |");
                        }
                    }
                    
                    else if(j==0)
                        System.out.print("                "+arr[i][0]+" |");

                    else
                        System.out.print(" "+arr[i][j]+" |");
                }

                else
                {
                    if(arr[i][j] == ".")
                    {
                        if(i == 0)
                            System.out.println(" 3");

                        if(i == 1)
                            System.out.println(" 6");

                        if(i == 2)
                            System.out.println(" 9");
                    }
                    else
                        System.out.println(" "+arr[i][j]);
                }
            }

            if(i != 2)
                System.out.println("               ---|---|---");
        }

    }

    static boolean hasWon(String arr[][])
    {
        int i, j, p1 = 0, p2 = 0;

        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                if(arr[i][j].equals("X"))
                    p1++;

                else if(arr[i][j].equals("C"))
                    p2++;
            }

            if(p1==3 || p2==3)
                return true;

            p1 = 0;
            p2 = 0;
        }

        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                if(arr[j][i].equals("X"))
                    p1++;

                else if(arr[j][i].equals("C"))
                    p2++;
            }

            if(p1==3 | p2==3)
                return true;
            
            p1 = 0;
            p2 = 0;
        }

        for(i = 0; i<3; i++)
        {
            if(arr[i][i].equals("X"))
                p1++;

            else if(arr[i][i].equals("C"))
                p2++;
        }

        if(p1==3 | p2==3)
            return true;

        p1 = 0;
        p2 = 0;

        for(i=0,j=2; j>=0; i++,j--)
        {
            if(arr[i][j].equals("X"))
                p1++;

            else if(arr[i][j].equals("C"))
                p2++;
        }

        if(p1==3 | p2==3)
            return true;

        return false;
    }
    
    
    static boolean isFull(String arr[][])
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j].equals("."))
                    return false;
            }
        }

        return true;
    }
    
    
    static void delay() throws InterruptedException
    {
        //Loading has to be performed 3 times
        for(int i=0;i<3;i++)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("\t\t\t\t\tPlease Wait for a few moments");
            System.out.print("\t\t\t\t\t\t   Loading");

            Thread.sleep(700);
            System.out.print(".");

            Thread.sleep(600);
            System.out.print(".");

            Thread.sleep(700);
            System.out.print(".");

            Thread.sleep(750);
            System.out.print("\f");
        }

        Thread.sleep(200);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t\tHere we go...");

        Thread.sleep(2000);
        System.out.print("\f");
    }
    
    
    public static void prints(String s, boolean line, int time) throws InterruptedException
    {
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            System.out.print(ch);
            Thread.sleep(200);
        }

        Thread.sleep(time);

        if(line)
            System.out.println();
    }
}
