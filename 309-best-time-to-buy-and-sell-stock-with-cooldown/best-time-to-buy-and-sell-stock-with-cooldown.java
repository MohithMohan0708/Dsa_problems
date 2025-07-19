class Solution {
    public int func(int i,int buy,int[] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[i]+func(i+1,0,prices,dp),0+func(i+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[i]+func(i+2,1,prices,dp),0+func(i+1,0,prices,dp));
        }
        dp[i][buy] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = func(0,1,prices,dp);
        return ans;
    }
}