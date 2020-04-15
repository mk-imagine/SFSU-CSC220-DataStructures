package asmt02Part03;

import java.util.Scanner;
/**
 *
 * A class that determines whether or not a string is a palindrome;
 * that is, a string that's able to be spelled the same way from
 * left to right as it is right to left, ignoring punctuation,
 * spaces, and case.
 *
 */
public class PalindromeChecker 
{
    private static OurStack palindromeStack;
    /** 
     *
     * Tests whether a string is a palidrome, 
     * ignoring punctuation, spaces, and case. 
     * 
     * @param aString  A string.
     * @return
     *
     * */
    public static boolean isPalindrome(String aString)
    {
        StringBuilder tempString = new StringBuilder(aString.toLowerCase());
        boolean result = true;
        
        removeAllPunctuation(tempString);
        
        palindromeStack = new OurStack();
        for (int i = 0; i < tempString.length(); i++) {
            palindromeStack.push(tempString.charAt(i));
        }
        
        if (tempString.length() != palindromeStack.getCurrentSize()) {
            return false;
        }
        
        boolean done = false;
        int continuingIndex = 0;
        int numChars = tempString.length();
        while (!done && (continuingIndex < numChars))
        {
            // Check whether the character at the top of the stack
            // is equal to the character at the current position in tempString.
            done = palindromeStack.isEmpty();
            if (tempString.charAt(continuingIndex) != (char)palindromeStack.pop()) {
                result = false;
            }
            continuingIndex++;
        } // end while
        
        return result;
    } // end isPalindrome

    /** Removes all punctuation from a string.
     *
     * @param aString  The String to be processed.
     * @return  Count of punctuation removed. 
     *
     */
    public static int removeAllPunctuation(StringBuilder aString) {
        int counter = 0;
        for (int i = 0; i < aString.length(); i++) {
            if (isPunctuation(aString.charAt(i))) {
                aString.deleteCharAt(i);
                i--;
                counter++;
            }
        }
        return counter;
    }

    /** Tests whether a character is a punctuation mark, such as a period.
     *
     * @param aCharacter  The character to be tested.
     * @return  True if the character is a punctuation mark, or false if not. 
     *
     */
    public static boolean isPunctuation(char aCharacter)
    {
        return aCharacter < 65                          // Less than 'A'
                || (aCharacter > 90 && aCharacter < 97) // Between 'Z' and 'a'
                || aCharacter > 122;                    // Greater than 'z'
    } // end isPunctuation

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print("Enter a string that you want to check (or enter ! to exit): ");
            String pCheck = keyboard.nextLine();
            if (pCheck.equals("!")) {
                System.out.println("Done!");
                done = true;
            } else {
                System.out.println(pCheck + " " + (isPalindrome(pCheck) ? "IS a palindrome!" : "is NOT a palindrome!"));
            }
        }
    } // end main
} // end PalindromeChecker