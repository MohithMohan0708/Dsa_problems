class Solution {
    public int func(int i, int target, int[] coins, int[][] dp){
        if(target==0){
            return 1;
        }
        if(i==0){
            if(target%coins[i]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notpick = func(i-1,target,coins,dp);
        int pick = 0;
        if(target>=coins[i]){
            pick = func(i,target-coins[i],coins,dp);
        }
        return dp[i][target] = pick + notpick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }   
        return func(n-1,amount,coins,dp);
    }
}