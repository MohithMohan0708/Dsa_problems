class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i]==nums[i-1]) continue;
            int l = i - 1;
            while(l>=0 && nums[l]==nums[i]){
                l-=1;
            }
            int r = i + 1;
            while(r<nums.length && nums[r]==nums[i]){
                r++;
            }
            if(l>=0 && r<nums.length){
                if((nums[l]<nums[i] && nums[r]<nums[i]) || (nums[l]>nums[i] && nums[r]>nums[i])){
                count++;
                }
            }
        }
        return count;
    }
}