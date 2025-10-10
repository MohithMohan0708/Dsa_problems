class Solution {
    public boolean isJewel(char ch, String jewels){
        return jewels.indexOf(ch)!=-1;
    }
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(char ch : stones.toCharArray()){
            if(isJewel(ch,jewels)){
                count+=1; 
            }
        }
        return count;
    }
}