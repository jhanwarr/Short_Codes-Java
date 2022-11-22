package Generic_Queue;

import java.util.NoSuchElementException;

public class Queue207Implementation <AnyType> implements Queue207<AnyType>
{	
	private int numberItems;
	private QueueNode<AnyType> head;
	private QueueNode<AnyType> tail;
	
	/**
	 * Default Constructor to create a new Queue
	 */
	public Queue207Implementation() 
	{	
		this.numberItems = 0;
		this.head = null;
		this.tail = null;
		
	}
	
	/**
	 * Constructor for initializing the Queue with a pre-existing Queue
	 * @param numberItems the size of the pre-existing Queue
	 * @param head The head of the pre-existing Queue
	 * @param tail The tail of the pre-existing Queue
	 */
	public Queue207Implementation(int numberItems, QueueNode<AnyType> head, QueueNode<AnyType> tail)
	{
		this.numberItems = 0;
		this.head = head;
		this.tail = tail;
	}
	

	public boolean add(AnyType e) throws NullPointerException
	{
		if(e == null)
			throw new NullPointerException("The input is null. ");
		
		//if the new QueueNode is the first QueueNode of the queue
		if(numberItems == 0) 
		{
			head = new QueueNode<>(e, null);
			tail = head;
		}

		else 
		{
			tail.setNext(new QueueNode<>(e, null));
			tail = tail.getNext();
		}
		
		numberItems++;
		
		return true;
	}
	
	
	 public AnyType remove() throws NoSuchElementException
	 {
		 if(numberItems == 0)
			 throw new NoSuchElementException("The queue is empty. ");
		 
		 AnyType d = head.getData();
		 
		 if(numberItems == 1) 
		 {
			 head = null;
			 tail = null;
		 }
		 
		 else 
		 {
			 head = head.getNext();
		 }
		 	 
		 numberItems--;
		  
		 return d;
	 }
	
	 /**
	  * The function to take a peek at the data stored in the first node
	  */
	 public AnyType element() throws NoSuchElementException
	 {
		 if(numberItems == 0)
			 throw new NoSuchElementException("The queue is empty. ");
		 
		 return head.getData();
	 }
	 

	 public int size()
	 {
		 return numberItems;
	 }
}
