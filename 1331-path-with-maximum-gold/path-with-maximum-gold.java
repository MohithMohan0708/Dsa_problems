class Solution {
    int m, n;
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    public int dfs(int row, int col, int[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        int gold = grid[row][col];
        int maxGold = 0;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                grid[nrow][ncol] != 0 && !vis[nrow][ncol]) {
                maxGold = Math.max(maxGold, dfs(nrow, ncol, grid, vis));
            }
        }

        vis[row][col] = false;
        return gold + maxGold;
    }

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxSum = 0;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxSum = Math.max(maxSum, dfs(i, j, grid, vis));
                }
            }
        }
        return maxSum;
    }
}
