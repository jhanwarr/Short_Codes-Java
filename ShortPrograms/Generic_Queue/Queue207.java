package Generic_Queue;

import java.lang.NullPointerException;
import java.util.NoSuchElementException;

public interface Queue207 <AnyType>
{
    /**
     * inserts the specified element e into this queue, if it is possible to do so
     * @param e the element to add
     * @return true upon success
     * @throws NullPointerException if e is null
     */
    public boolean add (AnyType e) throws NullPointerException;

    /**
     * retrieves and removes the head of this queue
     * @return the head of this queue
     * @throws NoSuchElementException  if this queue is empty
     */
    public AnyType remove () throws NoSuchElementException;

    /**
     * retrieves, but does not remove, the head of this queue
     * @return the head of this queue
     * @throws NoSuchElementException  if this queue is empty
     */
    public AnyType element () throws NoSuchElementException;

    /** 
     * The size of the Queue
     * @return the number of elements in this queue
     */
    public int size();
}
