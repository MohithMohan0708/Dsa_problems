class Solution {
    public int lcs(int i, int j, String s1, String s2, int[][] dp){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(lcs(i-1,j,s1,s2,dp),lcs(i,j-1,s1,s2,dp));
    } 
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = lcs(m,n,str1,str2,dp);
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){ //up condition
                sb.append(str1.charAt(i-1)); //we used 1-based indexing so subtract 1
                i--;
            }
            else{
                sb.append(str2.charAt(j-1)); // left condition
                j--;
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}