package asmt03Part1E;

/**
 *
 * 1 E
 *
 */
public class ArraySortByFirst
{
	/** 
	 * Sorts an array of integers by the first value of each row. After
	 * sorting, the first column of the array is in ascending order.
	*/
	public static void sortByFirst(int data[][])
	{
            int indexOfNextSmallest;
            for (int i = 0; i < data.length - 1; i++) {
                indexOfNextSmallest = getIndexOfSmallest(data, i, data.length - 1);
                swap(data, i, indexOfNextSmallest);
            }
	}
        
	/**  
	 * Finds the index of the smallest value in a portion of an array.
         */
	private static int getIndexOfSmallest(int[][] a, int first, int last)
        {
            int min = a[first][0];
            int indexOfMin = first;
            for (int i = first + 1; i <= last; i++) {
                if (a[i][0] < min) {
                    min = a[i][0];
                    indexOfMin = i;
                }
            }
            return indexOfMin;
	}
        
	/**
	 * Swaps the rows a[i] and a[j].
	*/
	private static void swap(int[][] a, int i, int j)
	{
            int tmp;
            for (int k = 0; k < a[i].length; k++) {
                tmp = a[i][k];
                a[i][k] = a[j][k];
                a[j][k] = tmp;
            }
	}

	/** 
	 * Displays the two-dimensional array.
	*/
	public static void display(int data[][])
	{
            for (int[] data1 : data) {
                System.out.print("   ");
                for (int i = 0; i < data[0].length; i++) {
                    System.out.printf("%3d", data1[i]);
                }
                System.out.println();
            }
	} 

	/**
	 * Tester
	 * You do not need to change any code in the main method
	 *
	*/
	public static void main(String args[])
	{
            int array[][] = {{1, 2, 3, 4, 5}, 
                             {3, 4, 5, 1, 2}, 
                             {5, 2, 3, 4, 1}, 
                             {2, 3, 1, 4, 5}, 
                             {4, 2, 3, 1, 5}};
            
            System.out.println("The array is initially " );
            display(array);
            System.out.println();
            
            sortByFirst(array);
            System.out.println("The array after sorting is " );
            display(array);
            System.out.println();
	}
}