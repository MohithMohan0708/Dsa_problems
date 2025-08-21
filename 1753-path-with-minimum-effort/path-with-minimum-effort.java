class Tuple{
    int effort,row,col;
    Tuple(int effort, int row, int col){
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->Integer.compare(x.effort,y.effort));
        pq.offer(new Tuple(0,0,0));
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int effort = t.effort;
            int row = t.row;
            int col = t.col;
            if(row==m-1 && col==n-1) return effort;
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && Math.max(effort,Math.abs(heights[row][col]-heights[nrow][ncol]))<dist[nrow][ncol]){
                    dist[nrow][ncol] =  Math.max(effort,Math.abs(heights[row][col]-heights[nrow][ncol]));
                    pq.offer(new Tuple(dist[nrow][ncol],nrow,ncol));
                }
            }
        }
        return 0;
    }
}