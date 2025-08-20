class Solution {
    public int func(int i, int target, int[] coins, int[][] dp){
        if(target==0){
            return 0;
        }
        if(i==0){
            if(target%coins[0]==0){
                return target/coins[0];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake = 0 + func(i-1,target,coins,dp);
        int take = (int)1e9;
        if(coins[i]<=target){
            take = 1 + func(i,target-coins[i],coins,dp);
        }
        return dp[i][target] = Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        if(func(n-1,amount,coins,dp)==Math.abs(1e9)){
            return -1;
        }
        return func(n-1,amount,coins,dp);
    }
}