class Solution {
    public boolean isPowerOfFour(int n) {
        long val = 1;
        while(val<n){
            val*=4;
        }
        if(val==n){
            return true;
        }
        return false;
    }
}