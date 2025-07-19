class Solution {
    public int func(int i, int buy, int k, int[] prices,int[][][] dp){
        if(i==prices.length || k<=0) return 0;
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[i]+func(i+1,0,k,prices,dp), 0 + func(i+1,1,k,prices,dp));
        }
        else{
            profit = Math.max(prices[i]+func(i+1,1,k-1,prices,dp), 0 + func(i+1,0,k,prices,dp));
        }
        dp[i][buy][k] = profit;
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] row: dp){
            for(int[] row1:row){
                Arrays.fill(row1,-1);
            }
        }
        int profit = func(0,1,k,prices,dp);
        return profit;
    }
}