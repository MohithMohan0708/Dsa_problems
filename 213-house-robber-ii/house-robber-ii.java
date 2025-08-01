class Solution {
    public int func(int i,int[] nums,int[] dp){
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int notpick = func(i-1,nums,dp);
        int pick = nums[i] + func(i-2,nums,dp);
        dp[i] = Math.max(notpick,pick);
        return dp[i];
    }
    public int rob(int[] nums) {
       int n = nums.length;
       if(n==1) return nums[0];
       int[] dp = new int[n-1];
       Arrays.fill(dp,-1);
       int ans1 = func(n-2,nums,dp);
       int[] arr = new int[n-1];
       for(int i = 1; i < n; i++){
            arr[i-1] = nums[i];
       }
        int[] dp2 = new int[n - 1];
        Arrays.fill(dp2, -1);
        int ans2 = func(n - 2, arr, dp2);
       return Math.max(ans1,ans2);
    }
}