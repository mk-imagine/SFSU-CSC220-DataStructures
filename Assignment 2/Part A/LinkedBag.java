package asmt02Part01;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author (modifier) Duc Ta
 * @author (student modified) Mark Kim
 * 
 * @param <T>
 */
public final class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode; // point to first node in chain
        
        while (!found && (currentNode != null)) { // continue search if anEntry is not found and the current node is not the last node in the chain
            if (anEntry.equals(currentNode.data)) { // if anEntry data matches the data in the current node (starting with firstNode) return true
                found = true;
            }
            else {
                currentNode = currentNode.next; // if anEntry data does not match the data in the current node, move to the next node
            } // end if
        } // end while
        return found; // return boolean if the data contains anEntry
    } // end contains
    
    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode; // point to first node in chain

        while (!found && (currentNode != null)) { // continue search if anEntry is not found and the current node is not the last node in the chain
            if (anEntry.equals(currentNode.data)) { // if anEntry data matches the data in the current node return true
                found = true;
            } else {
                currentNode = currentNode.next; // if anEntry data does not match the data in the current node, move to the next node
            }
        } // end while

        return currentNode; // return the node that matches anEntry
    } // end getReferenceTo

    // Removes a given entry within this bag.
    // Returns boolean if a given entry was removed.
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry); // find node that contains anEntry and reference that node
        
        if (nodeN != null) {
            nodeN.data = firstNode.data; // Replace located entry with data in the first node
            firstNode = firstNode.next; // Remove first node
            numberOfEntries--; // Reduces the entry count
            result = true;
        } // end if
        
        return result;
    } // end remove
    
    /**
     * Gets the number of entries currently in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    @Override
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)        
        firstNode = newNode;      // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    @Override
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while

        return result;
    } // end toArray

    /**
     * Removes all occurrences of the given entries
     *
     * @return count of occurrences removed
     */
    @Override
    public int removeAllOccurences(T[][] entries) {

        // Convert 2D array to 1D array
        ArrayList<T> tmpArray = new ArrayList(convert2dto1dArrayList(entries)); // Call helper method to convert 2d array to 1d ArrayList
        // Remove duplicates in array
        removeArrayDuplicates(tmpArray);  // Call helper method to remove ArrayList duplicates
        // Remove all occurences of given items
        int counter = 0;
        if (!isEmpty()) {                                       // Check if bag is empty
            Node currentNode = firstNode;                       // Point to the first node in bag
            T currentEntry;                                     // Initialize data portion of Node
            while (currentNode != null) {                       // Iterate through bag until end of bag
                for (int i = 0; i < tmpArray.size(); i++) {     // Loop through array of entries
                    currentEntry = currentNode.data;            // Retrieve data from currentNode
                    if (currentEntry.equals(tmpArray.get(i))) { // Check if data from current node matches current item in Array
                        currentNode.data = firstNode.data;      // Move data to firstNode
                        firstNode = firstNode.next;             // Remove firstNode by pointing to the next node
                        numberOfEntries--;                      // Reduce the size counter for linked list size
                        counter++;                              // Increase counter
                    }
                }
                currentNode = currentNode.next;                 // Points to the next node in the bag to be checked
            }
        }
        return counter; // return a count of the number of entries removed
    } // end removeAllOccurences
    
    // Convert 2D array to 1D ArrayList
    private ArrayList<T> convert2dto1dArrayList(T[][] array2d) {
        ArrayList<T> array1d = new ArrayList();  // initialize ArrayList
        for (T[] row : array2d) {                // move through 1st dimension of array
            array1d.addAll(Arrays.asList(row));  // add all entries in 2nd dimension of array into array1d
        }
        return array1d;
    } // end convert2dto1dArrayList
    
    // Remove all duplicates from ArrayList
    private void removeArrayDuplicates(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {            // loop through array from lowest index to highest index
            for (int j = arrayList.size() - 1; j > i; j--) {    // for each item in array move from highest index to the current item
                if (arrayList.get(i).equals(arrayList.get(j)))  // checks if the lower index item matches higher index item
                    arrayList.remove(j);                        // if the match is found, the duplicate is removed
            }
        }
    } // end removeArrayDuplicates
    
    
    
    private class Node {

        private T data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node
} // end LinkedBag

