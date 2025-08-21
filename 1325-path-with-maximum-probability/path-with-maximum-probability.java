class Pair {
    double prob;
    int node;
    Pair(double prob, int node) {
        this.prob = prob;
        this.node = node;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(prob, v));
            adj.get(v).add(new Pair(prob, u));
        }
        double[] ans = new double[n];
        ans[start_node] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(1.0, start_node));
        while (!pq.isEmpty()) {
            double prob = pq.peek().prob;
            int node = pq.peek().node;
            pq.poll();
            if (node == end_node) return prob;
            for (Pair next : adj.get(node)) {
                double newProb = prob * next.prob;
                if (newProb > ans[next.node]) {
                    ans[next.node] = newProb;
                    pq.offer(new Pair(newProb, next.node));
                }
            }
        }
        return 0.0;
    }
}
