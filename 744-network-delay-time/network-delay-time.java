class Pair{
    int dist,node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row : times){
            int u = row[0];
            int v = row[1];
            int w = row[2];
            adj.get(u).add(Arrays.asList(v,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->(x.dist-y.dist));
        int[] ans = new int[n+1];
        for(int i = 0; i < n+1; i++){
            ans[i] = (int)1e9;
        }
        pq.add(new Pair(0,k));
        ans[k] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeW = adj.get(node).get(i).get(1);
                int v = adj.get(node).get(i).get(0);
                if(dist+edgeW<ans[v]){
                    ans[v] = dist+edgeW;
                    pq.add(new Pair(ans[v],v));
                }
            }
        } 
        int maxi = (int)-1e9;
        for(int i = 1; i < n+1;i++){
            if(ans[i]==1e9){
                return -1;
            }
            maxi = Math.max(maxi,ans[i]);
        }
        return maxi;
    }
}