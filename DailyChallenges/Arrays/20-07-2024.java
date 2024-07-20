//1605. Find Valid Matrix Given Row and Column Sums

/*
You are given two arrays rowSum and colSum of non-negative integers where rowSum[i] is the sum of the elements in the ith row and colSum[j] is the sum of the elements
of the jth column of a 2D matrix. In other words, you do not know the elements of the matrix, but you do know the sums of each row and column.
Return a 2D array representing any matrix that fulfills the requirements. It's guaranteed that at least one matrix that fulfills the requirements exists.

Input: rowSum = [5,7,10], colSum = [8,6,8]
Output: [[0,5,0],
         [6,1,0],
         [2,0,8]]
*/


class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];
        int x = 0;
        while(x < n+m-1){
            int i = findMin(rowSum);
            int j = findMin(colSum);
            int rowMin = rowSum[i];
            int colMin = colSum[j];
        
            if(rowMin < colMin){
                int k = 0;
                for(; k<m; k++){
                    if(colSum[k] >= rowMin)
                        break;
                }
                matrix[i][k] = rowMin;
                colSum[k] -= rowMin;
                rowSum[i] = 0;
            }
            else if(rowMin != 0 && colMin != 0){
                int k = 0;
                for(; k<n; k++){
                    if(rowSum[k] >= colMin)
                        break;
                }
                matrix[k][j] = colMin;
                rowSum[k] -= colMin;
                colSum[j] = 0;
            }
            x++;
        }
        return matrix;
    }
    private int findMin(int[] arr){
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0 && arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
