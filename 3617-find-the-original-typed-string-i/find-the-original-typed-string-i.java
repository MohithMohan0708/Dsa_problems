class Solution {
    public int possibleStringCount(String word) {
        int total = 1;
        int n = word.length();
        int i = 0;

        while (i < n) {
            char ch = word.charAt(i);
            int count = 1;
            while (i + 1 < n && word.charAt(i + 1) == ch) {
                count++;
                i++;
            }
            if (count > 1) {
                total += (count - 1);
            }
            i++;
        }

        return total;
    }
}