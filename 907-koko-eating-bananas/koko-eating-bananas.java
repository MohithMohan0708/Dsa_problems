class Solution {
    public int findMax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    public int calculateTime(int[] arr, int hourly){
        int totalTime = 0;
        for(int i = 0; i < arr.length; i++){
            totalTime += Math.ceil((double)arr[i]/(double)hourly);
        }
        return totalTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while(low<=high){
            int mid = (low+high)/2;
            int reqTime = calculateTime(piles,mid);
            if(reqTime<=h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}