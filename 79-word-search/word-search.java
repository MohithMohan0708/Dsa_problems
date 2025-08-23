class Solution {
    public boolean dfs(int i, int j, int k, char[][] board, String word, int[][] vis){
        if(k==word.length()) return true;
        int m = board.length;
        int n = board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==1 || board[i][j]!=word.charAt(k)){
            return false;
        }
        vis[i][j] = 1;
        boolean up = dfs(i-1,j,k+1,board,word,vis);
        boolean left = dfs(i,j-1,k+1,board,word,vis);
        boolean down = dfs(i+1,j,k+1,board,word,vis);
        boolean right = dfs(i,j+1,k+1,board,word,vis);
        vis[i][j] = 0;
        return (up || left || down || right);
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,board,word,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}