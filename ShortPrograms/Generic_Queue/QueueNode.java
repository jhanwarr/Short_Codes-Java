package Generic_Queue;

public class QueueNode <AnyType>
{
   private AnyType data;
   private QueueNode<AnyType> next;

   /**
    * The default constructor sets the data and next fields to null
    */
   public QueueNode ()
   {
      data = null;
      next = null;
   }

   /**
    * An alternative constructor that initializes the data and next 
    * parameters with an already existing one
    * @param origData The pre-exisiting Data
    * @param origNext The node next to the original data
    */
   public QueueNode (AnyType origData, QueueNode<AnyType> origNext)
   {
      data = origData;
      next = origNext;
   }

   public AnyType getData()
   {
      return data;
   }

   public void setData(AnyType d)
   {
      data = d;
   }

   public QueueNode<AnyType> getNext()
   {
      return next;
   }

   public void setNext(QueueNode<AnyType> n)
   {
      next = n;
   }
}
