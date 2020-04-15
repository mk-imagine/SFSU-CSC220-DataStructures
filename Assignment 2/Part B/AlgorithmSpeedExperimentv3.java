package asmt02Part02;

/**
 * Experiment to test the speed of different loops
 * 
 * @author Mark
 */

public class AlgorithmSpeedExperimentv3 {
    
    static int[] iterationsRangeLarge = {5000, 15000};
    static int[] iterationsRangeSmall = {50, 150};
    static int incrementsLarge = 1000;
    static int incrementsSmall = 1;
    static int noOfTests = 5;
    static long sum;
    static long startTime;
    static long endTime;
    static long[][] loopA1times;
    static long[][] loopA2times;
    static long[][] loopBtimes;
    static long[][] loopCtimes;
    static long[] loopA1Avg;
    static long[] loopA2Avg;
    static long[] loopBAvg;
    static long[] loopCAvg;
    static long timeDiffAB;
    static long timeDiffAC;
    
    public static void main(String[] args) {
        
        System.out.println("Please wait while I test the loops' speed.");
        loopA1times = loopTest('a', iterationsRangeLarge[0], iterationsRangeLarge[1], incrementsLarge, noOfTests);
        loopA2times = loopTest('a', iterationsRangeSmall[0], iterationsRangeSmall[1], incrementsSmall, noOfTests);
        loopBtimes = loopTest('b', iterationsRangeLarge[0], iterationsRangeLarge[1], incrementsLarge, noOfTests);
        loopCtimes = loopTest('c', iterationsRangeSmall[0], iterationsRangeSmall[1], incrementsSmall, noOfTests);
        loopA1Avg = loopAverage(loopA1times);
        loopA2Avg = loopAverage(loopA2times);
        loopBAvg = loopAverage(loopBtimes);
        loopCAvg = loopAverage(loopCtimes);
        int abIntersection = findIntersection(loopA1Avg, loopBAvg);
        int acIntersection = findIntersection(loopA2Avg, loopCAvg);
        timeDiffAB = loopA1Avg[abIntersection] - loopBAvg[abIntersection];
        timeDiffAC = loopA2Avg[acIntersection] - loopCAvg[acIntersection];
        System.out.println("\nI completed " 
                + noOfTests 
                + " tests of each loop and have concluded the following:");
        System.out.println("\nLoop A vs. Loop B comparison:");
        System.out.println("\tWith an n value of " 
                + loopA1times[0][abIntersection]
                + ", Loop A averaged " 
                + loopA1Avg[abIntersection] 
                + " nanoseconds to complete, while loop B averaged " 
                + loopBAvg[abIntersection] 
                + " nanoseconds to complete.");
        System.out.println("\tLoop B is estimated to be faster than loop A for n values less than " 
                + loopA1times[0][abIntersection] 
                + ".");
        System.out.println("\nLoop A vs. Loop C comparison:");
        System.out.println("\tWith an n value of " + loopA2times[0][acIntersection] 
                + ", Loop A averaged " 
                + loopA2Avg[acIntersection] 
                + " nanoseconds to complete, while loop C averaged " 
                + loopCAvg[acIntersection] 
                + " nanoseconds to complete.");
        System.out.println("\tLoop C is estimated to be faster than loop A for n values less than " 
                + loopA2times[0][acIntersection] 
                + ".");
        
    }
    
    private static int findIntersection(long[] arr1, long[] arr2) {
        long timeDiffFirst = arr1[0] - arr2[0];
        long timeDiffLast = arr1[arr1.length - 1] - arr2[arr1.length - 1];
        int i = 0;
        if (timeDiffFirst <= 0 && timeDiffLast <= 0 || timeDiffFirst > 0 && timeDiffLast > 0) {
            return Math.abs(timeDiffFirst) < Math.abs(timeDiffLast) ? -1 : -2; // First index smallest = -1, Last = -2
        }
        else if (timeDiffFirst <= 0) {
            while (arr1[i] < arr2[i]) {
                i++;
            }
        }
        else {
            while (arr1[i] > arr2[i]) {
                i++;
            }
        }
        return i;
    }
    
    private static long[] loopAverage(long[][] data) {
        long[] result = new long[data[0].length];
        for (int i = 0; i < data[0].length; i++) {
            for (long[] data1 : data) {
                result[i] += data1[i];
            }
            result[i] = result[i] / data.length;
        }
        return result;
    }
    
    private static long[][] loopTest(char loop, int minIterations, int maxIterations, int increments, int noOfTests) {
        long[][] results = new long[noOfTests + 1][(maxIterations - minIterations)/increments];
        for (int j = 0; j < results[0].length; j++) {
            results[0][j] = minIterations + (increments * j);
        }
        switch (loop) {
            case 'a': case 'A':
                loopA(minIterations);
                for (int i = 1; i < noOfTests + 1; i++) {
                    for (int j = 0; j < results[0].length; j++) {
                        results[i][j] = loopA(minIterations + (increments * j));
                    }
                }
                break;
            case 'b': case 'B':
                loopB(minIterations);
                for (int i = 1; i < noOfTests + 1; i++) {
                    for (int j = 0; j < results[0].length; j++) {
                        results[i][j] = loopB(minIterations + (increments * j));
                    }
                }
                break;
            case 'c': case 'C':
                loopC(minIterations);
                for (int i = 1; i < noOfTests + 1; i++) {
                    for (int j = 0; j < results[0].length; j++) {
                        results[i][j] = loopC(minIterations + (increments * j));
                    }
                }
                break;
            default:
                System.out.println("No such loop.");
                System.exit(1);
        }
        return results;
    }
    
    private static long loopA(int n) {
        startTime = System.nanoTime();
        sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10000; j++) {
                sum = sum + j;
            }
        }
        endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    private static long loopB(int n) {
        startTime = System.nanoTime();
        sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum = sum + j;
            }
        }
        endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    private static long loopC(int n) {
        startTime = System.nanoTime();
        sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                sum = sum + k;
                }
            }
        }
        endTime = System.nanoTime();
        return endTime - startTime;
    }
}