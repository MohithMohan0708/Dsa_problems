class Solution {
    public boolean func(int i, int count, String s, int[][] dp){
        if(count<0){
            return false;
        }
        if(i==s.length()){
            return (count==0);
        }
        if(dp[i][count]!=-1) return dp[i][count]==0;
        boolean ans = false;
        if(s.charAt(i)=='(') ans = func(i+1,count+1,s,dp);
        else if(s.charAt(i)==')') ans = func(i+1,count-1,s,dp);
        else ans = func(i+1,count,s,dp) || func(i+1,count-1,s,dp) || func(i+1,count+1,s,dp);
        if(ans){
            dp[i][count] = 0;
        }
        else dp[i][count] = 1;
        return ans;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(0,0,s,dp);
    }
}