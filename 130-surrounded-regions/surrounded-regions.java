class Solution {
    public void dfs(int i, int j, int[][] vis, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = i + delrow[k];
            int ncol = j + delcol[k];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        for (int j = 0; j < n; j++) { 
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, vis, board);
            }
            if (board[m - 1][j] == 'O' && vis[m - 1][j] == 0) {
                dfs(m - 1, j, vis, board);
            }
        }
        for (int i = 0; i < m; i++) { 
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, vis, board);
            }
            if (board[i][n - 1] == 'O' && vis[i][n - 1] == 0) {
                dfs(i, n - 1, vis, board);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
