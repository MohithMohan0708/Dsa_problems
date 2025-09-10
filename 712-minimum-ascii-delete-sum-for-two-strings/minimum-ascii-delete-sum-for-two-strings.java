class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        int lsum = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (int)s1.charAt(i-1) + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        lsum = dp[m][n];
        int fsum = 0, ssum = 0;
        for(char ch : s1.toCharArray()) fsum += (int)ch;
        for(char ch : s2.toCharArray()) ssum += (int)ch;
        return Math.abs(fsum+ssum - 2*lsum);
    }
}