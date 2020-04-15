package asmt03Part2D;

/**
 *
 * 2 D
 *
 */
public class CircularDoublyLinkedDeque<T> implements DequeInterface<T> 
{
	private DLNode firstNode;

	public CircularDoublyLinkedDeque() 
	{
            firstNode = null;
	} 

	public void addToBack(T newEntry) 
	{
            DLNode newNode = new DLNode(newEntry);
            if (firstNode == null) {
                newNode.next = newNode;
                newNode.previous = newNode;
                firstNode = newNode;
            }
            else {
                DLNode previousNode = firstNode.previous;
                previousNode.next = newNode;
                firstNode.previous = newNode;
                newNode.previous = previousNode;
                newNode.next = firstNode;
            }
	} 

	public void addToFront(T newEntry) 
	{
            DLNode newNode = new DLNode(newEntry);
            if (firstNode == null) {
                newNode.next = newNode;
                newNode.previous = newNode;
                firstNode = newNode;
            }
            else {
                DLNode previousNode = firstNode.previous;
                previousNode.next = newNode;
                firstNode.previous = newNode;
                newNode.previous = previousNode;
                newNode.next = firstNode;
                firstNode = newNode;
            }
	} 

	public T getFront() 
	{
            return firstNode.data;
	}

	public T getBack() 
	{
            return firstNode.previous.data;
	}

	public T removeFront() 
	{
            if (firstNode == null) {
                throw new EmptyQueueException();
            }
            else {
                DLNode frontNode = firstNode.next;
                DLNode backNode = firstNode.previous;
                T firstNodeData = firstNode.data;
                frontNode.previous = backNode;
                backNode.next = frontNode;
                firstNode = frontNode;
                return firstNodeData;
            }
	}

	public T removeBack() 
	{
            if (firstNode == null) {
                throw new EmptyQueueException();
            }
            else {
                DLNode previousNode = firstNode.previous.previous;
                T backNodeData = firstNode.previous.data;
                previousNode.next = firstNode;
                firstNode.previous = previousNode;
                return backNodeData;
            }
	}

	public void clear() 
	{
            firstNode = null;
	}

	public boolean isEmpty() 
	{
            return firstNode == null;
	}

	/**
	 * class DLNode
	 * You do not need to change any code in class DLNode
	 *
	*/
	private class DLNode
	{
		private T      data;  	 // Deque entry
		private DLNode next;  	 // Link to next node
		private DLNode previous; // Link to previous node

		private DLNode()
		{
			this(null, null, null);
		} // end default constructor

		private DLNode(T dataPortion)
		{
			this(null, dataPortion, null);
		} // end constructor

		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode)
		{
			data = dataPortion;
			next = nextNode;	
			previous = previousNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private DLNode getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(DLNode nextNode)
		{
			next = nextNode;
		} // end setNextNode

		private DLNode getPreviousNode()
		{
			return previous;
		} // end getPreviousNode

		private void setPreviousNode(DLNode previousNode)
		{
			previous = previousNode;
		} // end setPreviousNode
	} // end DLNode

} // end CircularDoublyLinkedDeque

