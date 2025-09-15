class Solution {
    public boolean isInBroken(char ch, String broken){
        return broken.indexOf(ch)!=-1;
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr  = text.split(" ");
        int count = 0;
        for(String curr : arr){
            for(int i = 0; i < curr.length(); i++){
                if(isInBroken(curr.charAt(i),brokenLetters)){
                    break;
                }
                if(i == curr.length()-1){
                    count++;
                }
            }
        }
        return count;
    }
}