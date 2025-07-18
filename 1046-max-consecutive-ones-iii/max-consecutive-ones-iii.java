class Solution {
    public int longestOnes(int[] nums, int k) {
        //consider this as longest subarray with atmost k zeroes
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroes = 0;
        while(r<nums.length){
            if(nums[r] == 0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            else{
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}