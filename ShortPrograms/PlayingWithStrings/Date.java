package PlayingWithStrings;

import java.util.Scanner;

class Date
{
    private int y,m,d;
    
    public static void main(String[] args)
    {
        Date obj = new Date();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the date in the format DD/MM/YYYY : ");
        String s = sc.next();

        ValidDate valid = new ValidDate(s);
        
        if(!valid.validate())
        {
            System.out.println("Invalid date entered.");
            System.exit(0);
        }

        boolean leap = false;
        obj.d = Integer.valueOf(s.substring(0,2));
        obj.m = Integer.valueOf(s.substring(3,5));
        obj.y = Integer.valueOf(s.substring(6,10));

        //do the validation of the date

        if(obj.y % 4 == 0)
        {
            if(obj.y % 400 == 0)
                leap=true;

            else if(obj.y % 100 == 0)
                leap=false;

            else 
                leap=true;
        }
        
        int[] ar = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        if(leap == true)
            ar[1] = 29;
         
        System.out.println("Enter the number of days to be added : ");
        int extra=sc.nextInt();
        
        int check = ar[obj.m-1]-obj.d;
        
        if(check > extra)
        {
            obj.d += extra;
            System.out.println(obj.d+"/"+obj.m+"/"+obj.y);
            System.exit(1);
        }
        
        else
        {
            extra -= check;
            obj.m++;
            obj.d = 0;
        }
        
        obj.yearIncrementer();
        
        while(extra != 0)
        {
            obj.d++;
            extra--;
            
            if(obj.d > ar[obj.m-1])
            {
                obj.m++;
                obj.d = 1;
                obj.yearIncrementer();
            }
            
        }
        System.out.println(obj.d+"/"+obj.m+"/"+obj.y);
        
        sc.close();
    }
    public void yearIncrementer()
    {
        if(m > 12)
        {
            m = 1;
            y++;
        }
    }
}
