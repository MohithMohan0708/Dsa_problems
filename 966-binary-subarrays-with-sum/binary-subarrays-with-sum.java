class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int count = 0, sum = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
}