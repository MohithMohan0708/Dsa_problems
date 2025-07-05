class Solution {
    public int findLucky(int[] arr) {
        int[] hash = new int[501];
        for(int item:arr){
            hash[item] += 1;
        }
        int maxi = -1;
        for(int i = 0; i < 501; i++){
            if(i==hash[i]){
                maxi = Math.max(maxi,i);
            }
        }
        return (maxi==0) ? -1 : maxi;
    }
}