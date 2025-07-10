class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        for(int i = 0; i < fruits.length; i++){
            for(int j = 0; j < fruits.length; j++){
                if(fruits[i]<=baskets[j] && baskets[j]!=0){
                    baskets[j] = 0;
                    break;
                }
                if(j == fruits.length - 1){
                    unplaced+=1;
                }
            }
        }
        return unplaced;
    }
}