class Tuple{
    double dist;
    int xcord;
    int ycord;
    Tuple(double dist, int xcord, int ycord){
        this.dist = dist;
        this.xcord = xcord;
        this.ycord = ycord;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->Double.compare(a.dist,b.dist));
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int curr = (x*x)+(y*y);
            double dist = Math.sqrt(curr);
            pq.offer(new Tuple(dist,x,y));
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            int x = pq.peek().xcord;
            int y = pq.peek().ycord;
            pq.remove();
            ans[i][0] = x;
            ans[i][1] = y;
        }
        return ans;
    }
}