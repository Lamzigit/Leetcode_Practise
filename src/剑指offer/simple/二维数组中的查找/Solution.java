package 剑指offer.simple.二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int num_row = matrix.length, num_col = matrix[0].length;
        int row_s = 0, col_s = num_col - 1;
        while(row_s<num_row && col_s >= 0){
            if(matrix[row_s][col_s] == target){
                return true;
            } else if (matrix[row_s][col_s] > target){
                col_s--;
            } else {
                row_s++;
            }
        }
        return false;
    }
}
