class Solution {
    public int func(int i, int j, int[][] dungeon, int[][] dp) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
        }
        if (dp[i][j] != -1) return dp[i][j];
        int right = func(i, j + 1, dungeon, dp);
        int down = func(i + 1, j, dungeon, dp);
        int minNext = Math.min(right, down);
        int need = minNext - dungeon[i][j];
        dp[i][j] = (need <= 0) ? 1 : need;
        return dp[i][j];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(0, 0, dungeon, dp);
    }
}