package 剑指offer.hard.二维数组中的查找;

public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length, col = array[0].length;
        int sr = 0, sc = col -1;
        while(sr < row && sc >= 0){
            if(array[sr][sc] == target) return true;
            if(array[sr][sc] > target){
                sc--;
            } else {
                sr++;
            }
        }
        return false;
    }
}
