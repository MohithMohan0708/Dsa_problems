class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        int sum = 0;
        int lines = 1; 
        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a']; 
            if (sum + width > 100) {
                lines++;
                sum = width; 
            } else {
                sum += width;
            }
        }

        ans[0] = lines; 
        ans[1] = sum; 
        return ans;
    }
}
