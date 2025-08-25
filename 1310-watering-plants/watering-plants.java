class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count = 0;
        int intialCapacity = capacity;
        for(int i = 0; i < plants.length; i++){
            if(plants[i]<=capacity){
                capacity -= plants[i];
                count++;
            }
            else{
                count += i+i+1;
                capacity = intialCapacity;
                capacity -= plants[i];
            }
        }   
        return count;
    }
}