package asmt02Part01;

/**
 * A demonstration of the class LinkedBag.
 * 
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author (modifier) Duc Ta
 * 
 */
public class LinkedBagTester {

    public static void main(String[] args) {
        System.out.println("[+] Creating an empty bag...");
        BagInterface<String> aBag = new LinkedBag<>();
        displayBag(aBag);

        // Adding strings
        System.out.println("[+] Creating bag items...");
        String[] contentsOfBag = {"A", " ", " ", "G", "Bb", "A", " ", "u", "n",
                                  "o", "A", "o", "d", "Bb", "A", "A", "l", "l"};
        testAdd(aBag, contentsOfBag);

        // Removing all occurence of the given entries from a bag
        System.out.println("[+] Creating a 2D testArray... \t");
        String[][] testArray = {
            {"A", "A", "A", "A", "A", "A"},
            {"B", "Bb", "Bb"},
            {"C", " "},
            {"n", "u", "l", "l"}
        };
        for (String[] row : testArray) {
            System.out.print("\t\t\t\t\t");
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("[+] Removing testArray items from the bag...");
        aBag.removeAllOccurences(testArray);
        displayBag(aBag);

    } // end main

    // Tests the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("[+] Adding the bag items to the bag: \t");
        for (String content1 : content) {
            aBag.add(content1);
            System.out.print(content1 + " ");
        } // end for
        System.out.println();

        displayBag(aBag);
    } // end testAdd

    // Tests the method toArray while displaying the bag.
    private static void displayBag(BagInterface<String> aBag) {
        System.out.print("- The bag now contains " + aBag.getCurrentSize()
                + " string(s): \t");
        Object[] bagArray = aBag.toArray();
        for (Object bagArray1 : bagArray) {
            System.out.print(bagArray1 + " ");
        } // end for

        System.out.println("\n");
    } // end displayBag

} // end LinkedBagDemo
