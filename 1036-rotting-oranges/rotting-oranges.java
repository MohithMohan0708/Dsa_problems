class Pair{
    int row, col, time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int cntFresh = 0;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int count = 0;
        int time = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int tm = q.peek().time;
            q.remove();
            time = Math.max(time,tm);
            for(int i = 0; i < 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow>=0 && nrow<m && ncol >= 0 && ncol<n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.offer(new Pair(nrow,ncol,tm+1));
                    vis[nrow][ncol] = 2;
                    count+=1;
                }
            }
        }
        return (count==cntFresh) ? time : -1;
    }
}