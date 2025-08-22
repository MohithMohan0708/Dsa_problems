class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination){
                return true;
            }
            for(Integer it : adj.get(node)){
                if(vis[it]!=1){
                    q.offer(it);
                    vis[it] = 1;
                }
            }
        }
        return false;
    }
}