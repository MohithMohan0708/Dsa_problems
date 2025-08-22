class Solution {
    public int editDist(int i, int j, String word1, String word2, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return editDist(i-1,j-1,word1,word2,dp);
        int ans = 1 + Math.min(
            editDist(i,j-1,word1,word2,dp), //insert
            Math.min( 
            editDist(i-1,j,word1,word2,dp), //delete
            editDist(i-1,j-1,word1,word2,dp)) //replace
        );
        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return editDist(m-1,n-1,word1,word2,dp);
    }
}