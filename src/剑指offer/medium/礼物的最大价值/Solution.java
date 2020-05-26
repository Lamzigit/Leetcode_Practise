package 剑指offer.medium.礼物的最大价值;

public class Solution {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                int top = dp[i-1][j] + grid[i][j];
                int left = dp[i][j-1] + grid[i][j];
                dp[i][j] = Math.max(top, left);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
