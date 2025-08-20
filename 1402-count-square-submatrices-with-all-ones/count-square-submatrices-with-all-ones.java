class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i>0 && j>0 && matrix[i][j]==1){
                    matrix[i][j] = Math.min(matrix[i][j-1], Math.min(matrix[i-1][j-1],matrix[i-1][j]))+1;
                }
                ans+=matrix[i][j];
            }
        }
        return ans;
    }
}