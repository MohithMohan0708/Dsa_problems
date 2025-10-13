//here in this question we consider in opposite direction from ocean to land 
class Solution {
    int[] delRow = {-1,0,1,0};
    int[] delCol = {0,1,0,-1};
    int m , n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        m = heights.length;
        n= heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int j = 0; j < n; j++){ //top-row all cols
            dfs(0,j,heights,pacific);
        }
        for(int i = 0; i < m; i++){ //first-col all rows
            dfs(i,0,heights,pacific);
        }
        for(int j = 0; j < n; j++){ //last-row all cols
            dfs(m-1,j,heights,atlantic);
        }
        for(int i = 0; i < m; i++){ //last-col all rows
            dfs(i,n-1,heights,atlantic);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int r, int c, int[][] heights, boolean[][] visited){
        if(visited[r][c]) return;
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];
            if(nrow<0 || nrow>=m || ncol<0 || ncol>=n){
                continue;
            }
            if(heights[nrow][ncol]<heights[r][c]){
                continue;
            }
            dfs(nrow,ncol,heights,visited);
        }
    }
}