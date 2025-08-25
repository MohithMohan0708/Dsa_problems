class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict){
            maxLen = Math.max(word.length(),maxLen);
            set.add(word);
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i - 1; j >= Math.max(0,(j-maxLen)); j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}