class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        if(result.size()==numCourses){
            for(int i = 0; i < result.size(); i++){
                ans[i] = result.get(i);
            }
            return ans;
        }
        else{
            return new int[0];
        }
    }
}