class Solution {
    public int lcs(int i, int j, String s, String srev, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==srev.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s,srev,dp);
        }
        return dp[i][j] = Math.max(lcs(i-1,j,s,srev,dp),lcs(i,j-1,s,srev,dp));
    }
    public int minInsertions(String s) {
        StringBuilder sreverse = new StringBuilder(s).reverse();
        String srev = sreverse.toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = lcs(n-1,n-1,s,srev,dp);
        return n-ans;
    }
}