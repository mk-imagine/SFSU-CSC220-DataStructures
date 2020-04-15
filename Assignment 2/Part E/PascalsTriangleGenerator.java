package asmt02Part05;

public class PascalsTriangleGenerator {

    private static final int[] ROW1 = {1}, ROW2 = {1,1};

    /**
     * Creates the initial two rows of Pascal's triangle.
     */
    public PascalsTriangleGenerator() {
        
    }
    
    /**
     * Recursively computes the specified row of Pascal's Triangle.
     * @param rowToCompute
     * @return last row in Pascal's Triangle
     */
    public int[] computeRow(int rowToCompute) {
        switch (rowToCompute) {
            case 1:
                return ROW1;
            case 2:
                return ROW2;
            default: 
                int[] currentRow = new int[rowToCompute];
                int[] previousRow = computeRow(rowToCompute - 1);
                currentRow[0] = 1;
                currentRow[rowToCompute - 1] = 1;
                for (int i = 1; i < rowToCompute - 1; i++) {
                    currentRow[i] = previousRow[i] + previousRow[i - 1];
                }
                return currentRow;
        }
    }
        
    /**
     * Computes the next row of Pascal's Triangle given the previous one.
     * @param previousRow
     * @return the next row of Pascal's Triangle
     */
    public int[] computeNextRow(int[] previousRow) {
        int newLength = previousRow.length + 1;
        int[] result = new int[newLength];
        result[0] = 1;
        for (int i = 1; i < newLength - 1; i++) {
            result[i] = previousRow[i] + previousRow[i - 1];
        }
        return result;
    }
}
