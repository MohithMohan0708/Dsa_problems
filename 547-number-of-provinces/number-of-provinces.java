class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i]==0){
                dfs(isConnected,vis,i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int[] vis, int node){
        vis[node] = 1;
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i]==0 && isConnected[node][i] == 1){
                dfs(isConnected, vis, i);
            }
        }
    }
}