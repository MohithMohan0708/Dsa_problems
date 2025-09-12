class Solution {
    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                count++;
            }
        }
        if(count==0) return false;
        return true;
    }
}