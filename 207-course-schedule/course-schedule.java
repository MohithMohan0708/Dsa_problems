class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());       
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return (numCourses == count);
    }
}