class Solution {
    public void dfs(int node, int parent, int[] subTreeXor, int[] timer, int[] InTime, int[] OutTime, int[] nums, ArrayList<ArrayList<Integer>> adj, int[] parentArr){
        subTreeXor[node] = nums[node];
        InTime[node] = timer[0]++;
        parentArr[node] = parent;
        for(Integer it : adj.get(node)){
            if(it != parent){
                dfs(it, node, subTreeXor, timer, InTime, OutTime, nums, adj, parentArr);
                subTreeXor[node] ^= subTreeXor[it];
            }
        }
        OutTime[node] = timer[0]++;
    }

    public boolean isAncestor(int u, int v, int[] InTime, int[] OutTime){
        return InTime[u] <= InTime[v] && OutTime[u] >= OutTime[v];
    }

    public int getScore(int a, int b, int c){
        int maxVal = Math.max(a, Math.max(b, c));
        int minVal = Math.min(a, Math.min(b, c));
        return maxVal - minVal;
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] subTreeXor = new int[n];
        int[] InTime = new int[n];
        int[] OutTime = new int[n];
        int[] timer = new int[1];
        int[] parentArr = new int[n];

        dfs(0, -1, subTreeXor, timer, InTime, OutTime, nums, adj, parentArr);
        ArrayList<Integer> cutNodes = new ArrayList<>();
        for (int v = 1; v < n; v++) { 
            cutNodes.add(v);
        }

        int ans = Integer.MAX_VALUE;
        for (int a = 0; a < cutNodes.size(); a++) {
            for (int b = a + 1; b < cutNodes.size(); b++) {
                int i = cutNodes.get(a);
                int j = cutNodes.get(b);
                int xor1, xor2, xor3;
                if (isAncestor(i, j, InTime, OutTime)) {
                    xor1 = subTreeXor[j];
                    xor2 = subTreeXor[i] ^ xor1;
                    xor3 = subTreeXor[0] ^ subTreeXor[i];
                } else if (isAncestor(j, i, InTime, OutTime)) {
                    xor1 = subTreeXor[i];
                    xor2 = subTreeXor[j] ^ xor1;
                    xor3 = subTreeXor[0] ^ subTreeXor[j];
                } else {
                    xor1 = subTreeXor[i];
                    xor2 = subTreeXor[j];
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2;
                }

                ans = Math.min(ans, getScore(xor1, xor2, xor3));
            }
        }
        return ans;
    }
}
