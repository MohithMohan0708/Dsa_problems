class Solution {
    public boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;

        String res = s.substring(0,1);
        int maxLen = 1;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= n; j++){
                String curr = s.substring(i,j);
                if(isPalindrome(curr) && curr.length() > maxLen){
                    maxLen = curr.length();
                    res = curr;
                }
            }
        }
        return res;
    }
}
