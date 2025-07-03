class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        while(word.length()<=k){
            String genStr = "";
            for(int i = 0; i < word.length(); i++){
                genStr += (word.charAt(i) == 'z') ? "a" : (char)(word.charAt(i)+1);
            }
            word += genStr;
        }
        return word.charAt(k-1);
    }
}