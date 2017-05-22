package com.company;

/**
 * Created by qurrat on 5/8/17.
 */
public class RotateMatrixClockwise {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{05,06,07,8}, {9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
        rotateClockwise(matrix);
        System.out.println("\n\nAfter rotation");
        printMatrix(matrix);

    }

    public static void rotateClockwise(int[][] matrix) {
        transposeMatrix(matrix);
        mirrorMatrix(matrix);
    }

    public static void transposeMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = i + 1; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }


    public static void mirrorMatrix(int[][] matrix){

        for ( int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] +"  ");
            }
            System.out.println();
        }
    }
}
