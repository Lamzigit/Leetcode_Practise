package 剑指offer.simple.连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0], sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum+nums[i], nums[i]);
            if(sum > max_sum){max_sum=sum;}
        }
        return max_sum;
    }
}
