class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSquared = Integer.MIN_VALUE;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            int diagonalSquared = length * length + width * width;
            int area = length * width;

            if (diagonalSquared > maxDiagonalSquared) {
                maxDiagonalSquared = diagonalSquared;
                maxArea = area;
            } else if (diagonalSquared == maxDiagonalSquared) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}