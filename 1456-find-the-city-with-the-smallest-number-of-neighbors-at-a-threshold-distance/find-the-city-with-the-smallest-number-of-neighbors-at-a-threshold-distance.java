class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++){
                if(i!=j){
                    dist[i][j] = (int)1e9;
                }
            }
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k]!=(int)1e9 && dist[k][j]!=(int)1e9){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int city = -1;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n;i++){
            int count = 0;
            for(int j = 0; j < n;j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=mini){
                mini = count;
                city = i;
            }
        }
        return city;
    }
}