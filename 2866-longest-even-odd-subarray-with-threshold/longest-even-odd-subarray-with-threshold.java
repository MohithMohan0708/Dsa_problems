class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int maxLength = 0;
        int left = 0, right = 0;
        
        while (right < nums.length) {
            if (nums[left] % 2 == 0 && nums[left] <= threshold) {
                // Expand the window while maintaining alternation and threshold condition
                while (right < nums.length && nums[right] <= threshold && validation(left, right, nums)) {
                    maxLength = Math.max(right - left + 1, maxLength);
                    right++;
                }
            } 
            left++;
            right = left; // Reset right pointer to start a new subarray
        }
        return maxLength;
    }
    
    public boolean validation(int start, int end, int[] nums) {
        for (int i = start; i < end; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
