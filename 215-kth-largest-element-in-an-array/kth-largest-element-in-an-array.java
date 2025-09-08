class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        } 
        int ans = -1;
        while(!pq.isEmpty()){
            k-=1;
            if(k==0){
                ans = pq.poll();
            }
            pq.poll();
        }
        return ans;
    }
}