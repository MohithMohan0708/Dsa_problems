class Solution {
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n+1; j++){
                String curr = s.substring(i,j);
                if(isPalindrome(curr)){
                    count++;
                }
            }
        }
        return count;
    }
}