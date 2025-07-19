class Solution {
    public int lcs(int i,int j,String s,String sb,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==sb.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s,sb,dp);
        }
        dp[i][j] = Math.max(lcs(i-1,j,s,sb,dp),lcs(i,j-1,s,sb,dp));
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        String sb = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return lcs(n-1,n-1,s,sb,dp);
    }
}