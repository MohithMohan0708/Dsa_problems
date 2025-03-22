class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        int m = edges.length;
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int completecount = 0;
        for(int i = 0; i < n; i++){
            if(vis[i]==0){
                ArrayList<Integer> component = new ArrayList<>();
                int edgecount = bfs(i,adj,component,vis);
                int size = component.size();
                if(edgecount == size*(size-1)/2){
                    completecount+=1;
                }
            }
        }
        return completecount;
    }
    public int bfs(int node, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> component,int[] vis){
        vis[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int edgecount = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            component.add(top);
            for(Integer it: adj.get(top)){
                edgecount+=1;
                if(vis[it]==0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
        return edgecount/2;
    }
}