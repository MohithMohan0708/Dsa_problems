import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }

        return maxSum;
    }
}
