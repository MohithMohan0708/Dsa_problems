class Pair {
    long dist;
    int node;
    Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] row : roads) {
            int u = row[0];
            int v = row[1];
            int w = row[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        int mod = (int) 1e9 + 7;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            long d = p.dist;
            int node = p.node;

            if (d > dist[node]) continue;

            for (int[] edge : adj.get(node)) {
                int nei = edge[0];
                int edw = edge[1];

                if (d + edw < dist[nei]) {
                    dist[nei] = d + edw;
                    pq.offer(new Pair(dist[nei], nei));
                    ways[nei] = ways[node];
                } else if (d + edw == dist[nei]) {
                    ways[nei] = (ways[nei] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}
