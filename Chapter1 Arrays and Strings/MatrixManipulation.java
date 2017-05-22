Ipackage com.company;

/**
 * Created by qulain on 5/9/2017.
 */
public class MatrixManipulation {

    public static void main(String[] args) {
        int[][] testCase1 = { {0,1,2,3}, {1,1,2,3}, {2,1,0,3}, {3,1,2,3}, {4, 1, 4,4} };
        int[][] testCase2 = { {00,5,2,1, 4}, {1,1,7,9, 2}, {0,2,1,3,4}, {9,1,2,3,3}, {4, 4, 2, 3, 0}};
        int[][] testCase3 = { {00}};


        replaceWithZeros(testCase1);
        printTwoDimensionalMatrix(testCase1);

        replaceWithZeros(testCase2);
        printTwoDimensionalMatrix(testCase2);

        replaceWithZeros(testCase3);
        printTwoDimensionalMatrix(testCase3);
    }

    public static void replaceWithZeros(int[][] m) {
        /* ALGORITHM:
        Step 1:
        Declare two arrays (one for rows, one for column)

        Step 2:
        Scan the matrix and if encounters 0, then update row array with 1 for value of i
        and then update column array with 1 for value of j

        Step 3:
        Again scan the matrix and if for any value of i, j, row and column values have value 1.
        Update that elements of matrix with zero
         */
        int[] row = new int[m.length];
        int[] col = new int[m[0].length];

        for(int i = 0; i < m.length; ++i) {
            for(int j = 0; j < m[0].length; ++j) {
                if(m[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < m.length; ++i) {
            for(int j = 0; j < m[0].length; ++j) {
                if(row[i] == 1 || col[j] == 1) {
                    m[i][j] = 0;
                }
            }
        }



    }

    public static void printTwoDimensionalMatrix(int[][] m) {
        for(int i =0; i < m.length; ++i) {
            for(int j = 0; j < m[0].length; ++j) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }


}
