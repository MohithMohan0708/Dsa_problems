class Tuple{
    int row, col, dist;
    Tuple(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] ans = new int[m][n];
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j]==0){
                    q.offer(new Tuple(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = -1;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.remove();
            ans[row][col] = dist;
            for(int i = 0; i < 4; i++){
                int nrow = row - delrow[i];
                int ncol = col - delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=1){
                    vis[nrow][ncol] = 1;
                    q.offer(new Tuple(nrow,ncol,dist+1));
                }
            }
        }
        return ans;
    }
}