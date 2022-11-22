package PlayingWithStrings;

class ValidDate
{
    private String date=""; 
    private boolean leap=false;
    
    ValidDate(String date)
    {
        this.date = date;
    }
    
    boolean validate()
    {
        int d = Integer.valueOf(date.substring(0,2));
        int m = Integer.valueOf(date.substring(3,5));
        int y = Integer.valueOf(date.substring(6,10));

        if(date.length() > 10 || date.charAt(2) != '/' || date.charAt(5) != '/')
        {
            //System.out.println("!!! Invalid Input !!!");
            return false;
        }

        else
        {
            if(year(y))
            {
                if(month(m))
                {
                    if(day(m, d))
                    {
                        //System.out.println("Valid Date. ");
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    public boolean year(int y)
    {
        if(y<1)
        {
            //System.out.println("Invalid Year");
            return false;
        }

        else
        {
            if(y%4==0)
            {
                if(y%400==0)
                    leap=true;

                else if(y%100!=0)
                    leap=true;
            }
        }
        return true;
    }

    public boolean month(int m)
    {
        if(m>12 || m<1)
        {
            //System.out.println("Invalid Month");
            return false;
        }

        return true;
    }

    public boolean day(int m, int d)
    {
        if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
        {
            if(d<1 || d>31)
            {
                //System.out.println("Invalid Date");
                return false;
            }
        }   

        else if(m==2)
        {
            if(leap==false)
            {
                if(d>28 || d<1)
                {
                    //System.out.println("Invalid Date");
                    return false;
                }
            }
            else if(leap==true)
            {
                if(d>29 || d<1)
                {
                    //System.out.println("Invalid Date");
                    return false;
                }
            }
        }

        else
        {
            if(d>30 || d<1)
            {
                //System.out.println("Invalid Date");
                return false;
            }
        }

        return true;
    }
}
