class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int count = 0;
        int maxSum = Integer.MIN_VALUE;
        while(r<n){
            if(nums[r]==0){
                count++;
            }
            while(count>1){
                if(nums[l]==0){
                    count--;
                }
                l++;
            }
            maxSum = Math.max(maxSum,(r-l+1));
            r++;
        }
        return maxSum-1;
    }
}