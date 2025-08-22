class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int row, int col, int[][] matrix, int[][] count){
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && matrix[nrow][ncol]>matrix[r][c] && count[nrow][ncol]<1+count[r][c]){
                    count[nrow][ncol] = 1 + count[r][c];
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count[][] = new int[m][n];
        for(int[] temp : count){
            Arrays.fill(temp,1);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                bfs(i,j,matrix,count);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                maxi = Math.max(count[i][j],maxi);
            }
        }
        return maxi;
    }
}