package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindNumberOfTransformationToMakeTwoMatrixEqual {

    private int arr1[][] ,arr2[][];

    public FindNumberOfTransformationToMakeTwoMatrixEqual(int[][] arr1, int[][] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public int countOperation(){
        // Update matrix A[][] so that only A[][] has to be countOpsed
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j <arr1[i].length; j++)
                arr1[i][j] = arr1[i][j] - arr2[i][j];
        // Check necessary condition for condition for existence of full countOpsation
        for (int i = 1; i < arr1.length; i++)
            for (int j = 1; j < arr1[i].length; j++)
                if (arr1[i][j] - arr1[i][0] - arr1[0][j] + arr1[0][0] != 0)
                    return -1;

        // If countOpsation is possible calculate total countOpsation
        int result = 0;
        for (int i = 0; i < arr1.length; i++)
            result += Math.abs(arr1[i][0]);

        for (int j = 0; j < arr1[0].length; j++)
            result += Math.abs(arr1[0][j] - arr1[0][0]);

        return (result);
    }

    public static void main(String[] args) {
        int A[][] = { {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1} };
        int B[][] = { {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9} };
        FindNumberOfTransformationToMakeTwoMatrixEqual twoMatrixEqual =new FindNumberOfTransformationToMakeTwoMatrixEqual(A ,B );
        System.out.println(twoMatrixEqual.countOperation());
    }
}
