class Solution {
    public int countSubsets(int[] nums, int currOr, int i, int maxOr){
        if(i==nums.length){
            return currOr == maxOr ? 1 : 0;
        }
        //include
        int incl = countSubsets(nums,currOr|nums[i],i+1,maxOr);
        //exclude
        int excl = countSubsets(nums,currOr,i+1,maxOr);
        return incl + excl;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxOr |= nums[i];
        }
        return countSubsets(nums,0,0,maxOr);
    }
}