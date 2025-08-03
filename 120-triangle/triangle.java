class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] grid = new int[m][m];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < triangle.get(i).size();j++){
                grid[i][j] = triangle.get(i).get(j);
            }
        }
        int[][] dp = new int[m][m];
        for(int j = 0; j < m;j++){
            dp[m-1][j] = grid[m-1][j];
        }
        for(int i = m-2; i >=0 ; i--){
            for(int j = i; j >= 0; j--){
                int down = grid[i][j] + dp[i+1][j];
                int diag = grid[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}