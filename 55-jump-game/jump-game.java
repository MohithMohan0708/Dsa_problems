class Solution {
    public boolean func(int ind, int[] nums, int[] dp){
        if(ind==nums.length-1){
            return true;
        }
        if(ind > nums.length-1){
            return false;
        }
        if(nums[ind]==0 && ind!=nums.length-1 ){
            return false;
        }
        if(dp[ind]!=-1) return dp[ind]==1;
        for(int i = ind+1; i <= nums[ind]+ind; i++){
            if(func(i,nums,dp)){
                dp[i] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(0,nums,dp);
    }
}