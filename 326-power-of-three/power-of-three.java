class Solution {
    public boolean isPowerOfThree(int n) {
        long ans = 1;
        while(ans<n){
            ans*=3;
        }
        if(ans==n) return true;
        return false;
    }
}