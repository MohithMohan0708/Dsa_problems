class Tuple{
    int stops;
    int wt;
    int node;
    Tuple(int stops,int wt,int node){
        this.stops = stops;
        this.wt = wt;
        this.node = node;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:flights){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v,wt});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0,0,src));
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int st = t.stops;
            int wt = t.wt;
            int node = t.node;
            if(st>k) continue;
            for(int[] a : adj.get(node)){
                int v = a[0];
                int edW = a[1];
                if(wt+edW<dist[v]){
                    dist[v] = wt+edW;
                    q.offer(new Tuple(st+1,dist[v],v));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}