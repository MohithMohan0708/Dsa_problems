class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int maxi = nums[1]-nums[0];
        for(int i = 2; i < nums.length; i++){
            maxi = Math.max(maxi,nums[i]-nums[i-1]);
        }
        return maxi;
    }
}