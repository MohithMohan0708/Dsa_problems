class Solution {
    public boolean isSafe(int row, int col, char[][] board, char dig){
        //horizontal
        for(int j = 0; j < 9; j++){
            if(board[row][j]==dig){
                return false;
            }
        }
        //vertical
        for(int i = 0; i < 9; i++){
            if(board[i][col]==dig){
                return false;
            }
        }
        //grid checking
        int stRow = (row/3) * 3;
        int stCol = (col/3) * 3;
        for(int i = stRow; i <= stRow+2; i++){
            for(int j = stCol; j <= stCol+2; j++){
                if(board[i][j] == dig){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean fillSudoku(int row, int col, char[][] board){
        if(row == 9){
            return true;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        if(board[row][col] != '.'){
            return fillSudoku(nextRow, nextCol, board);
        }
        for(char dig = '1'; dig <='9'; dig++){
            if(isSafe(row,col,board,dig)){
                board[row][col] = dig;
                if(fillSudoku(nextRow, nextCol, board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        fillSudoku(0,0,board);
    }
}