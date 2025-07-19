class Solution {
    public int func(int i,int buy,int[] prices,int[][] dp,int fee){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[i]+func(i+1,0,prices,dp,fee),0+func(i+1,1,prices,dp,fee));
        }
        else{
            profit = Math.max(prices[i]-fee+func(i+1,1,prices,dp,fee),0+func(i+1,0,prices,dp,fee));
        }
        dp[i][buy] = profit;
        return profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = func(0,1,prices,dp,fee);
        return ans;
    }
}