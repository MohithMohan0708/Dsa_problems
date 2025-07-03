class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        for(int i = 0; i < hash.length; i++){
            hash[i] = -1;
        }
        int l = 0, r = 0;
        int maxLen = 0;
        int n = s.length();
        while(r<n){
            if(hash[(int)s.charAt(r)]!=-1){
                if(hash[(int)s.charAt(r)]>=l){
                    l = hash[(int)s.charAt(r)]+1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len,maxLen);
            hash[(int)s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}