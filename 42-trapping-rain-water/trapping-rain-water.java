class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] premax = new int[n];
        int[] sufmax = new int[n];
        premax[0] = height[0];
        for(int i = 1; i < n; i++){
            premax[i] = Math.max(height[i],premax[i-1]);
        }
        sufmax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--){
            sufmax[i] = Math.max(height[i],sufmax[i+1]);
        }
        int total = 0;
        for(int i = 0; i < n; i++){
            int lmax = premax[i];
            int rmax = sufmax[i];
            if(height[i]<lmax && height[i]<rmax){
                total += Math.min(lmax,rmax) - height[i];
            }
        }
        return total;
    }
}