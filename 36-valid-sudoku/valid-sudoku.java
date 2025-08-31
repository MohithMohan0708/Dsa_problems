class Solution {
    public boolean isSafe(int row, int col, char[][] board){
        char dig = board[row][col];
        //horizontal
        for(int j = 0; j < 9; j++){
            if(j != col && board[row][j]==dig){
                return false;
            }
        }
        //vertical
        for(int i = 0; i < 9; i++){
            if(i!= row && board[i][col]==dig){
                return false;
            }
        }
        //grid
        int stRow = (row/3)*3;
        int stCol = (col/3)*3;
        for(int i = stRow; i <= stRow+2; i++){
            for(int j = stCol; j<=stCol+2; j++){
                if(i!=row && j!=col && board[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                else{
                    if(!isSafe(i,j,board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}