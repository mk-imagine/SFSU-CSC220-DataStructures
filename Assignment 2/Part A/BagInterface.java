package asmt02Part01;

/**
 * An interface that describes the operations of a bag of objects.
 * 
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author (student modified) Mark Kim
 * 
 * @param <T>
 */
public interface BagInterface<T> {

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Removes all occurrences of the given entries
     *
     * @param entries
     * @return count of occurrences removed
     */
    public int removeAllOccurences(T[][] entries); // changed return type to int (Mark)

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag. Note: If
     * the bag is empty, the returned array is empty.
     */
    public T[] toArray();

} // end BagInterface 

