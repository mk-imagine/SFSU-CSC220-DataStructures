package asmt03Part2D;

/**
 *
 * 2 D
 * You do not need to change any code in class EmptyQueueException
 *
*/
public class EmptyQueueException extends RuntimeException
{
   public EmptyQueueException()
   {
      this(null);
   } // end default constructor
   
   public EmptyQueueException(String message)
   {
      super(message);
   } // end constructor
} // end EmptyQueueException
