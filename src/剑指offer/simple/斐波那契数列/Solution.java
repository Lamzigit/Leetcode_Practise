package 剑指offer.simple.斐波那契数列;

public class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int f_0 = 0, f_1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (f_0 + f_1) % 1000000007;
            f_0 = f_1;
            f_1 = temp;
        }
        return f_1;
    }
}
