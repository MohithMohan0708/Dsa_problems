class Solution {
    public boolean formGroup(int[] hand, int group, int i){
        int count = 1;
        int element = hand[i]+1;
        int n = hand.length;
        while(i<n && count<group){
            if(element == hand[i]){
                element = hand[i]+1;
                hand[i] = -1;
                count+=1;
            }
            i+=1;
        }
        if(count == group){
            return true;
        }
        return false;
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        for(int i = 0; i < hand.length; i++){
            if(hand[i]!=-1){
                if(!formGroup(hand,groupSize,i)){
                return false;
                }
            }
        }
        return true;
    }
}