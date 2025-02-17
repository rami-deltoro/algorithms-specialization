package org.example.stanford.matrixmultiplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Master Method
 *
 * a = 8 :: Number of Recursive calls
 * b = 2 :: Factor smaller than input. Half the size of original array. Thus 2.
 * d = 2 :: Only calculations
 *
 *  This puts us on case 3 since a > b^d => 8 > 2^2 => O(n^log2 8) = > O(n^3)

 */
@Slf4j
public class MatrixMultiplication {

    public int[][] bruteForce(int[][] x, int[][] y) {
        int[][] result = new int[x.length][x.length];

        for(int i=0;i<x.length;i++) {
            for(int j=0;j<y.length;j++) {
                for(int k=0;k<y.length;k++) {
                    result[i][j] = result[i][j] + x[i][k]*y[k][j];
                }
            }
        }

        return result;
    }

    public int[][] divideAndConquerMatrixMultiplication(
            int[][] X, int[][] Y, int rowA, int colA,
            int rowB, int colB, int size){

        int[][] RESULT= new int[size][size];

        if(size==1)
            RESULT[0][0]= X[rowA][colA]*Y[rowB][colB];

        else{

            int newSize= size/2;

            int[][] AE = divideAndConquerMatrixMultiplication(X, Y, rowA, colA, rowB, colB, newSize);
            int[][] BG = divideAndConquerMatrixMultiplication(X, Y, rowA, colA+newSize, rowB+newSize, colB, newSize);
            sumMatrix(RESULT,AE,BG,0,0);


            int[][] AF = divideAndConquerMatrixMultiplication(X, Y, rowA, colA, rowB, colB + newSize, newSize);
            int[][] BH = divideAndConquerMatrixMultiplication(X, Y, rowA, colA+newSize, rowB+newSize, colB+newSize, newSize);
            sumMatrix(RESULT,AF,BH,0,newSize);

            int[][] CE = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA, rowB, colB , newSize);
            int[][] DG = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA+newSize, rowB+newSize, colB, newSize);
            sumMatrix(RESULT,CE,DG,newSize,0);

            int[][] CF = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA, rowB, colB+newSize , newSize);
            int[][] DH = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA+newSize, rowB+newSize, colB+newSize, newSize);
            sumMatrix(RESULT,CF,DH,newSize,newSize);

        }



        return RESULT;

    }




// Java Program to Implement Strassen Algorithm

    // Class Strassen matrix multiplication

        // Method 1
        // Function to multiply matrices
        public int[][] multiply(int[][] A, int[][] B)
        {
            // Order of matrix
            int n = A.length;

            // Creating a 2D square matrix with size n
            // n is input from the user
            int[][] R = new int[n][n];

            // Base case
            // If there is only single element
            if (n == 1)

                // Returning the simple multiplication of
                // two elements in matrices
                R[0][0] = A[0][0] * B[0][0];

                // Matrix
            else {
                // Step 1: Dividing Matrix into parts
                // by storing sub-parts to variables
                int[][] A11 = new int[n / 2][n / 2];
                int[][] A12 = new int[n / 2][n / 2];
                int[][] A21 = new int[n / 2][n / 2];
                int[][] A22 = new int[n / 2][n / 2];
                int[][] B11 = new int[n / 2][n / 2];
                int[][] B12 = new int[n / 2][n / 2];
                int[][] B21 = new int[n / 2][n / 2];
                int[][] B22 = new int[n / 2][n / 2];

                // Step 2: Dividing matrix A into 4 halves
                split(A, A11, 0, 0);
                split(A, A12, 0, n / 2);
                split(A, A21, n / 2, 0);
                split(A, A22, n / 2, n / 2);

                // Step 2: Dividing matrix B into 4 halves
                split(B, B11, 0, 0);
                split(B, B12, 0, n / 2);
                split(B, B21, n / 2, 0);
                split(B, B22, n / 2, n / 2);

                // Using Formulas as described in algorithm

                // M1:=(A1+A3)×(B1+B2)
                int[][] M1
                        = multiply(add(A11, A22), add(B11, B22));

                // M2:=(A2+A4)×(B3+B4)
                int[][] M2 = multiply(add(A21, A22), B11);

                // M3:=(A1−A4)×(B1+A4)
                int[][] M3 = multiply(A11, sub(B12, B22));

                // M4:=A1×(B2−B4)
                int[][] M4 = multiply(A22, sub(B21, B11));

                // M5:=(A3+A4)×(B1)
                int[][] M5 = multiply(add(A11, A12), B22);

                // M6:=(A1+A2)×(B4)
                int[][] M6
                        = multiply(sub(A21, A11), add(B11, B12));

                // M7:=A4×(B3−B1)
                int[][] M7
                        = multiply(sub(A12, A22), add(B21, B22));

                // P:=M2+M3−M6−M7
                int[][] C11 = add(sub(add(M1, M4), M5), M7);

                // Q:=M4+M6
                int[][] C12 = add(M3, M5);

                // R:=M5+M7
                int[][] C21 = add(M2, M4);

                // S:=M1−M3−M4−M5
                int[][] C22 = add(sub(add(M1, M3), M2), M6);

                // Step 3: Join 4 halves into one result matrix
                join(C11, R, 0, 0);
                join(C12, R, 0, n / 2);
                join(C21, R, n / 2, 0);
                join(C22, R, n / 2, n / 2);
            }

            // Step 4: Return result
            return R;
        }

        // Method 5
        // Function to join child matrices
        // into (to) parent matrix
        public void join(int[][] C, int[][] P, int iB, int jB)

        {
            // Iterating over elements of 2D matrix
            // using nested for loops

            // Outer loop for rows
            for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

                // Inner loop for columns
                for (int j1 = 0, j2 = jB; j1 < C.length;
                     j1++, j2++)

                    P[i2][j2] = C[i1][j1];
        }

        // Method 3
        // Function to add two matrices
        public int[][] add(int[][] A, int[][] B)
        {

            //
            int n = A.length;

            // Creating a 2D square matrix
            int[][] C = new int[n][n];

            // Iterating over elements of 2D matrix
            // using nested for loops

            // Outer loop for rows
            for (int i = 0; i < n; i++)

                // Inner loop for columns
                for (int j = 0; j < n; j++)

                    // Adding corresponding elements
                    // of matrices
                    C[i][j] = A[i][j] + B[i][j];

            // Returning the resultant matrix
            return C;
        }


        // Method 2
        // Function to subtract two matrices
        public int[][] sub(int[][] A, int[][] B)
        {
            //
            int n = A.length;

            //
            int[][] C = new int[n][n];

            // Iterating over elements of 2D matrix
            // using nested for loops

            // Outer loop for rows
            for (int i = 0; i < n; i++)

                // Inner loop for columns
                for (int j = 0; j < n; j++)

                    // Subtracting corresponding elements
                    // from matrices
                    C[i][j] = A[i][j] - B[i][j];

            // Returning the resultant matrix
            return C;
        }

    // Method 4
    // Function to split parent matrix
    // into child matrices
    public void split(int[][] P, int[][] C, int iB, int jB)
    {
        // Iterating over elements of 2D matrix
        // using nested for loops

        // Outer loop for rows
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            // Inner loop for columns
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)

                C[i1][j1] = P[i2][j2];
    }




    private void sumMatrix(int[][] RESULT, int[][]A, int[][]B,int rowC, int colC){
        int n=A.length;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++)
                RESULT[i+rowC][j+colC]=A[i][j]+B[i][j];
        }

    }






}
