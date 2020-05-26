package 剑指offer.medium.剪绳子;

public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[3];
        if (n == 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int temp = Math.max(Math.max(dp[(i - 1) % 3], i - 1), Math.max(2 * (i - 2), 2 * dp[(i - 2) % 3]));
            temp = Math.max(temp, Math.max(3 * (i - 3), 3 * dp[(i - 3) % 3]));
            dp[i % 3] = temp;
        }
        return dp[n % 3];
    }
}
