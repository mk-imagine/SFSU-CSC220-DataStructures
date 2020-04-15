package asmt03Part2D;

/** 
 *
 * 2 D
 * You do not need to change any code in class Driver
 *
 */
public class Driver 
{
	public static void main(String[] args) 
	{
		System.out.println("Create a deque: ");
		DequeInterface<String> myDeque = new CircularDoublyLinkedDeque<>();
		System.out.println("\n\nisEmpty() returns " + myDeque.isEmpty() + "\n");

		System.out.println("Add to front and back of deque to get\n" +
				"Joe Jess Jim Jill Jane Jerry\n");
		myDeque.addToFront("Jim");
		myDeque.addToFront("Jess");

		myDeque.addToBack("Jill");
		myDeque.addToBack("Jane");

		myDeque.addToFront("Joe");
		myDeque.addToBack("Jerry");

		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n");

		System.out.println("\n\nTesting getFront, getBack, removeFront, removeBack:\n");
		String front,  back;
		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");					

		front = myDeque.removeFront();
		System.out.println(front + " is removed from the front of the deque.");

		back = myDeque.removeBack();
		System.out.println(back + " is removed from the back of the deque.");

		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");	

		System.out.println("\n\nTesting clear:\n");
		myDeque.clear();
		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n\n");
		try
		{
			front = myDeque.removeFront(); 
			System.out.println("removeFront incorrectly finds queue not empty");
		} // end try
		catch (EmptyQueueException e)
		{
			System.out.println("removeFront correctly finds deque empty");
		} // end catch

		try
		{
			front = myDeque.removeBack(); 
			System.out.println("removeBack incorrectly finds queue not empty");
		} // end try
		catch (EmptyQueueException e)
		{
			System.out.println("removeBack correctly finds deque empty");
		} // end catch
		
		System.out.println("\nDone.");
	}  // end main
}  // end Driver
