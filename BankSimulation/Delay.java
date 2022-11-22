 
class Delay extends Beep
{
    static Thread t;

    static void delay(String s,boolean q,boolean wantMessage)throws Exception
    {
        if(wantMessage)
            message(s,false);//,false);

        if(q)
            System.out.print("\f");

        try
        {
            t=Thread.currentThread();

            for(int i=0;i<3;i++)
            //Loading has to be performed 3 times
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t\tPlease Wait for a few moments");
                System.out.print("\t\t\t\t\t\t   Loading");
                t.sleep(700);
                System.out.print(".");
                t.sleep(600);
                System.out.print(".");
                t.sleep(700);
                System.out.print(".");
                t.sleep(750);
                System.out.print("\f");
            }

            t.sleep(200);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t\t\t\tHere we go...");
            t.sleep(2000);
            System.out.print("\f");
        }
        catch(InterruptedException e)
        { System.out.println(t+" Interrupted."); }
    }
}
