package asmt02Part04;

import java.util.Random;

/**
 *
 * @author JavaF
 */
public class BlurbGenerator {

    private final int blurbRange = 6;
    private final Random gen;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        gen = new Random();
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     *
     * @return
     */
    public String makeBlurb() {
        return makeWhoozit() + makeWhatzit() + makeMultiWhatzits("", gen.nextInt(blurbRange));
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        return "x" + makeYString("", gen.nextInt(blurbRange));
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString(String m, int n) {
        if (n == 0) {
            return m;
        }
        else if (gen.nextInt() % 2 == 0) { 
            return makeYString(m + "y", n - 1);
        }
        else {
            return makeYString("y", n - 1);
        }
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits(String m, int n) {
        if (n == 0){
            return m;
        }
        else if (gen.nextInt() % 2 == 0){
            return makeMultiWhatzits(m + makeWhatzit(), n - 1);
        }
        else {
            return makeMultiWhatzits(m, n - 1);
        }
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
        String whatzit = "q";
        if(gen.nextInt() % 2 == 0){
            whatzit += "z";
        }
        else {
            whatzit += "d";
        }
        return whatzit + makeWhoozit();
    }
}