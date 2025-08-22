class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxRow = -1, maxCol = -1;
        int minRow = m, minCol = n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==1){
                    maxRow = Math.max(maxRow,i);
                    minRow = Math.min(minRow,i);
                    maxCol = Math.max(maxCol,j);
                    minCol = Math.min(minCol,j);
                }
            }
        }
        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }
}