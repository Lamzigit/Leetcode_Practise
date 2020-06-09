package 剑指offer.simple.n个骰子的点数;

import java.util.Arrays;

public class Solution {
    public double[] twoSum(int n) {
        int[] count = new int[]{0, 1, 1, 1, 1, 1, 1};
        if (n > 1) {
            int[] plus = new int[]{1, 2, 3, 4, 5, 6};
            for (int i = 1; i < n; i++) {
                int[] temp_count = new int[(i + 1) * 6 + 1];
                for (int sum = i; sum < count.length; sum++) {
                    for (int p : plus) {
                        temp_count[sum + p] += count[sum];
                    }
                }
                count = temp_count;
            }
        }
        double[] re = new double[count.length-n];
        double all = Math.pow(6, n);
        for(int i=n;i<count.length;i++){
            re[i-n] = count[i] * 1.0 / all;
        }
        return re;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(new Solution().twoSum(n)));
    }
}
