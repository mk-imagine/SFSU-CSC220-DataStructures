package asmt02Part05;

import java.util.Scanner;

public class PascalsTriangle {
    /**
     * Generates and prints the row of Pascal's Triangle 
     * requested by the user.
     * @param args
     */
    public static void main(String args[]) {
        PascalsTriangleGenerator pascal = new PascalsTriangleGenerator();
        Scanner scan = new Scanner(System.in);
        int[] pascalLastRow;
        String another = "y";
        //
	while (another.equalsIgnoreCase("y")) {
            System.out.print("Which line number of Pascal's Triangle? ");
            int lineNum = scan.nextInt();
            pascalLastRow = pascal.computeRow(lineNum);
            for (int i = 0; i < pascalLastRow.length; i++) {
                System.out.print(pascalLastRow[i] + " ");
            }
            System.out.print("\nAnother (y,n)? ");
            another = scan.next();
        }
    }
}
