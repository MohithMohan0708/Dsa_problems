class Solution {
    public int countSubset(int i, int target, int[] arr,int[][] dp){
        if(i==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==arr[0] || target==0) return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notpick = countSubset(i-1,target,arr,dp);
        int pick = 0;
        if(target>=arr[i]){
            pick = countSubset(i-1,target-arr[i],arr,dp);
        }
        return dp[i][target] = pick + notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }
        if((totalSum-target) < 0 || (totalSum-target)%2!=0) return 0;
        int k = (totalSum - target)/2;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return countSubset(n-1,k,nums,dp);
    }
}