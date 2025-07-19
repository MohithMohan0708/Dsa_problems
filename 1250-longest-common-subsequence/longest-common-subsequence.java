class Solution {
    public int func(int i,int j,String text1,String text2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+func(i-1,j-1,text1,text2,dp);
        }
        dp[i][j] = Math.max(func(i-1,j,text1,text2,dp),func(i,j-1,text1,text2,dp));
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = func(m-1,n-1,text1,text2,dp);
        return ans;
    }
}