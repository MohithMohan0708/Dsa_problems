class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                    vis[i][j] = 1;
                    break;
                }
            }
        }
        int peri = 0;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int count = 0;
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow<m && ncol<n && nrow>=0 && ncol>=0 && grid[nrow][ncol] == 1){
                    count+=1;
                }
                if(nrow<m && ncol<n && nrow>=0 && ncol>=0 && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1){
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
            if(count == 1){
                peri+=3;
            }
            else if(count == 2){
                peri+= 2;
            }
            else if(count == 3){
                peri+= 1;
            }
            else if(count == 0){
                peri+=4;
            }
        }
        return peri;
    }
}