class Solution {
    public void solve(char[][] board, int row, List<List<String>> ans, int n){
        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isSafe(row,i,board,n)){
                board[row][i] = 'Q';
                solve(board,row+1,ans,n);
                board[row][i] = '.';
            }
        }
    }
    public boolean isSafe(int row, int col, char[][] board, int n){
        //vertical safety
        for(int i = 0; i < n; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //horizontal safety
        for(int j = 0; j < n; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        //left diagonal
        for(int i = row, j = col; i >=0 && j >= 0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //right diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        solve(board,0,ans,n);
        return ans;
    }
}