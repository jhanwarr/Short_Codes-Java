package Generic_Queue;

import java.util.NoSuchElementException;

public class Queue207ImplementationTester 
{
    public static void main(String args[]) 
    {    
        Queue207Implementation<String> q1 = new Queue207Implementation<>();
        
        System.out.println("Operating with Strings\n");

        q1.add("Test 1");
        q1.add("Test 2");
        System.out.println("Element removed: " + q1.remove());
        System.out.println("The first element is: " + q1.element());
        System.out.println("The size is: " + q1.size());
        q1.add("Test 3");
        System.out.println("The size is: " + q1.size());
        System.out.println("Element removed: " + q1.remove());
        System.out.println("Element removed: " + q1.remove());
        System.out.println("The size is: " + q1.size());

        System.out.println("Removing from an empty queue: ");

        try 
        {
            q1.remove();
        }

        catch(NoSuchElementException e) 
        {
            System.out.println("NoSuchElementException has been encountered");
        }


        Queue207Implementation<Integer> q2 = new Queue207Implementation<>();

        System.out.println("\n\nOperating with Integers\n");
        
        q2.add(1);
        q2.add(2);
        System.out.println("Element removed: " + q2.remove());
        System.out.println("The first element is: " + q2.element());
        System.out.println("The size is: " + q2.size());
        q2.add(3);
        System.out.println("The size is: " + q2.size());
        System.out.println("Element removed: " + q2.remove());
        System.out.println("Element removed: " + q2.remove());
        System.out.println("The size is: " + q2.size());
        
        System.out.println("Removing from an empty queue: ");
        
        try 
        {
            q2.remove();
        }

        catch(NoSuchElementException e) 
        {
            System.out.println("NoSuchElementException has been encountered");
        }
        
    }
}
