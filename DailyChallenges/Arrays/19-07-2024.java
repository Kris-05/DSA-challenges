//1380. Lucky Numbers in a Matrix

/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for(int row=0; row<matrix.length; row++){
            int colIndex = findMin(matrix, row);  
            int val = matrix[row][colIndex];
            if(isMax(matrix, colIndex, val)){
                res.add(val);
            }
        }

        return res;
    }
    private int findMin(int[][] matrix, int row){
        int min = Integer.MAX_VALUE;
        int col = 0;
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[row][j] < min){
                min = matrix[row][j];
                col = j;
            }
        }
        return col;
    }
    private boolean isMax(int[][] matrix, int col, int val){
        for(int row=0; row<matrix.length; row++){
            if(matrix[row][col] > val)
                return false;
        }
        return true;
    }
}
