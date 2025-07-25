import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxElement = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : nums) {
            if (!set.contains(x)) {
                set.add(x);
                maxElement = Math.max(maxElement, x);
                if (x > 0) {
                    sum += x;
                }
            }
        }
        return sum > 0 ? sum : maxElement;
    }
}
