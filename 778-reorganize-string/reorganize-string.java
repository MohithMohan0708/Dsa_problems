class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxCount = 0;
        char maxChar = 'a';

        // Count character frequencies
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            if (count[ch - 'a'] > maxCount) {
                maxCount = count[ch - 'a'];
                maxChar = ch;
            }
        }

        // Check if reorganization is possible
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        // Fill the result with the most frequent char first
        char[] result = new char[s.length()];
        int idx = 0;
        while (count[maxChar - 'a'] > 0) {
            result[idx] = maxChar;
            idx += 2;
            count[maxChar - 'a']--;
        }

        // Place remaining characters
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1; // Fill odd positions now
                }
                result[idx] = (char)(i + 'a');
                idx += 2;
                count[i]--;
            }
        }

        return new String(result);
    }
}