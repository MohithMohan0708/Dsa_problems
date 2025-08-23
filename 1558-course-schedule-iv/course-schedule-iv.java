class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] row : prerequisites) {
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean[][] isPrereq = new boolean[numCourses][numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj.get(node)) {
                isPrereq[node][next] = true;
                for (int i = 0; i < numCourses; i++) {
                    if (isPrereq[i][node]) {
                        isPrereq[i][next] = true;
                    }
                }
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int[] query : queries) {
            ans.add(isPrereq[query[0]][query[1]]);
        }
        return ans;
    }
}
