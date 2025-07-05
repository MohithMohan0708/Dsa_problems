import java.util.*;

class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];

        // Prefix: count distinct characters from left
        Set<Character> leftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftSet.add(s.charAt(i));
            left[i] = leftSet.size();
        }

        // Suffix: count distinct characters from right
        Set<Character> rightSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(s.charAt(i));
            right[i] = rightSet.size();
        }

        // Count good splits
        int good = 0;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1]) {
                good++;
            }
        }

        return good;
    }
}
