class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int a = 0;
        int b = k;
        while(a+k-1<nums.size() && b+k-1<nums.size()){
            if(isIncreasing(a,a+k-1,nums) && isIncreasing(b,b+k-1,nums)){
                return true;
            }
            a+=1;
            b+=1;
        }
        return false;
    }
    public boolean isIncreasing(int start, int end, List<Integer> nums){
        while(start<end){
            if(nums.get(start)>=nums.get(start+1)){
                return false;
            }
            start+=1;
        }
        return true;
    }
}