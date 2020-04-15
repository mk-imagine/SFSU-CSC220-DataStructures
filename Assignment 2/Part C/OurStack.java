package asmt02Part03;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  A class of stacks.
 * @param <T>
 */
public class OurStack<T> implements StackInterface<T>
{
	Stack<T> theStack;
        private Node topNode;
        private int numberOfEntries;
        
	public OurStack() { 
            topNode = null;
            numberOfEntries = 0;
        } // end default constructor
        
        public int getCurrentSize() {
            return numberOfEntries;
        }

        @Override
	public void push(T newEntry) {
            topNode = new Node(newEntry, topNode);
            numberOfEntries++;
        } // end push

        @Override
	public T peek() {
            return topNode.getData();
        } // end peek

        @Override
	public T pop() {
            T top = peek(); // might throw EmptyStackException
            assert (topNode != null);
            topNode = topNode.getNextNode();
            numberOfEntries--;
            return top;
        } // end pop

        @Override
	public boolean isEmpty() {
            return topNode == null;
        } // end isEmpty

        @Override
	public void clear() {
            topNode = null;
            numberOfEntries = 0;
        } // end clear
        
        private class Node {
            
            private T data;
            private Node next;
            
            private Node (T dataPortion) {
                this(dataPortion, null);
            } // end constructor
            
            private Node (T dataPortion, Node linkPortion) {
                data = dataPortion;
                next = linkPortion;
            } // end constructor
            
            private T getData() {
                return data;
            } // end getData
            
            private void setData(T newData) {
                data = newData;
            } // end setData
            
            private Node getNextNode() {
                return next;
            } // end getNextNode
            
            private void setNextNode(Node nextNode) {
                next = nextNode;
            } // end setNextNode
        } // end Node

} // end OurStack
