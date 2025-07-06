class Pair{
    int row; int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(i,j,vis,grid);
                    count+=1;
                }
            }
        }
        return count;
    }
    public void bfs(int row, int col, int[][] vis, char[][] grid){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            for(int i = 0; i < 4; i++){
                int nr = r - delrow[i];
                int nc = c - delcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}