class Solution {
    public int func(int i, int j, int[][] grid, int[][] dp){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = func(i - 1, j, grid, dp);
        int left = func(i, j - 1, grid, dp);
        int minPath = Math.min(up, left);
        if(minPath == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }
        return dp[i][j] = grid[i][j] + minPath;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return func(m - 1, n - 1, grid, dp);
    }
}