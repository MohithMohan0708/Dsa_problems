class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[m];
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            for(int j : graph[i]){
                adj.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[m];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            if(safe[i]){
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }
}