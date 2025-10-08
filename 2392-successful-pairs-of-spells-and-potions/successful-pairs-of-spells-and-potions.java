class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            int index = getOptimal(spells[i], potions, success);
            pairs[i] = m - index;
        }
        return pairs;
    }

    public int getOptimal(int curr, int[] potions, long success) {
        int start = 0;
        int end = potions.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long val = (long) curr * potions[mid];
            if (val >= success) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}