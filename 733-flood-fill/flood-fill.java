class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int co = image[sr][sc];
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] delrow = {0,-1,0,1};
            int[] delcol = {1,0,-1,0};
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            for(int i = 0; i < 4; i++){
                int newr = r + delrow[i];
                int newc = c + delcol[i];
                if(newr>=0 && newr<m && newc>=0 && newc<n && vis[newr][newc] == 0 && image[newr][newc] == co){
                    image[newr][newc] = color;
                    vis[newr][newc] = 1;
                    q.offer(new Pair(newr,newc));
                }
            }
        }
        return image;
    }
}