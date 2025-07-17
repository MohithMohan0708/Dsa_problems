class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int maxi = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    int res = bfs(i,j,grid,vis);
                    if(res>maxi){
                        maxi = res;
                    }
                }
            }
        }
        return maxi;
    }
    public int bfs(int row,int col,int[][] grid,int[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));
        vis[row][col] = 1;
        int count = 1;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            for(int i = 0; i < 4; i++){
                int nr = r + delRow[i];
                int nc = c + delCol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                    count++;
                    q.offer(new Pair(nr,nc));
                    vis[nr][nc] = 1;
                }
            }
        }
        return count;
    }
}