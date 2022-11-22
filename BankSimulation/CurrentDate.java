import java.util.*;
class CurrentDate extends Delay
{
    void getDate(boolean start)
    {
        GregorianCalendar d=new GregorianCalendar();
        int day=d.get(Calendar.DAY_OF_MONTH);
        int month=d.get(Calendar.MONTH);
        int year=d.get(Calendar.YEAR);
        
        System.out.println("Today's date is "+day+"/"+(month+1)+"/"+year);
        if(start)
        {
            int cd=day;
            int cm=month;
            int cy=year;
        }
    }
}
