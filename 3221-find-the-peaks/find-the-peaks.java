class Solution {
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n==1 || n == 2) return ans;
        for(int i = 1 ; i < n - 1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }
}