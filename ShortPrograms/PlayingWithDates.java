/*
 * Program to accept the number of any day (between 1 and 366) and the year (YYYY) from the user 
 * to generate and display the corresponding date. Also, accept ‘N’ from the user to compute and 
 * display the future date corresponding to ‘N’ days after the generated date. 
 */

import java.util.Scanner;

public class PlayingWithDates
{
    private final String MO[] = {"", "January", "February", "March", "April", "May", "June", "July", "August", "Spetember", "October", "November", "December"};
    private final int D[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //Arrays containing the months and their days
    
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        PlayingWithDates ob = new PlayingWithDates();

        System.out.print("Enter the day number : ");
        int day = sc.nextInt();

        System.out.print("Enter the year : ");
        int year = sc.nextInt();

        //VALIDATION of day and year
        
        if(day > ob.isLeap(year))
        {
            System.out.println("DAY NUMBER OUT OF RANGE");
        }

        if(year<1000 || year>9999)
        {
            System.out.println("YEAR OUT OF RANGE");
        }

        
        System.out.print("Enter the number of days after : ");
        int n = sc.nextInt();
        sc.close();


        System.out.println("\n\nDate – "+ob.findDate(day,year));
        
        System.out.println("\nDate after "+n+" days – "+ob.future(day,year,n));
    }

    public int isLeap(int y) //function to check for leap year and return max days
    {
        if((y%400 == 0) || (y%100 != 0 && y%4 == 0))
            return 366;

        else
            return 365;
    }

    String postfix(int n) //function to find postfix of the number
    {
        int r = n%10;
        if(r == 1 && n != 11)
            return "st";

        else if(r == 2 && n != 12)
            return "nd";

        else if(r == 3 && n != 13)
            return "rd";

        else
            return "th";
    }

    public String findDate(int d, int y) //function to find the date from day number
    {
        if(isLeap(y)==366)
        {
            D[2] = 29;
        }

        int m = 1;

        while(d > D[m])
        {
            d = d - D[m];
            m++;
        }

        return (d+postfix(d)+" "+MO[m]+", "+y);
    }

    public String future(int d, int y, int n) //function to find future date
    {
        int max = isLeap(y);
        d = d + n;

        while(d>max)
        {
            d = d - max;
            y++; 
        }

        return findDate(d,y); 
    }       
}