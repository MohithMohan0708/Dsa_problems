class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        boolean up = true;
        int row = 0;
        int col = 0;
        for(int i = 0; i < m*n ; i++){
            ans[i] = mat[row][col];
            if(up){ // up-right
                if(col==n-1){
                    row++;
                    up = false;
                }
                else if(row==0){
                    col++;
                    up = false;
                }
                else{
                    row--;
                    col++;
                }
            }
            else{ //down-left
                if(row == m-1){
                    col++;
                    up = true;
                }
                else if(col == 0){
                    row++;
                    up = true;
                }
                else{
                    row++;
                    col--;
                }
            }
        }   
        return ans;
    }
}