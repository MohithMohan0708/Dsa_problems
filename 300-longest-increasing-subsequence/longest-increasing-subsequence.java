class Solution {
    public int lis(int i, int prev, int[] nums, int[][] dp){
        int n = nums.length;
        if(i == n) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int notpick = lis(i+1, prev, nums, dp);
        int pick = 0;
        if(prev == -1 || nums[i] > nums[prev]){
            pick = 1 + lis(i+1, i, nums, dp);
        }

        return dp[i][prev+1] = Math.max(pick, notpick);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return lis(0, -1, nums, dp);
    }
}
