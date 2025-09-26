class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pq.offer(matrix[i][j]);
            }
        }
        while(k-1 > 0){
            System.out.println(pq.poll());
            k--;
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}