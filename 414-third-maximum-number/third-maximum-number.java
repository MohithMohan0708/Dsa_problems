class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int item : set){
            pq.offer(item);
        }
        if(pq.size()<3){
            return pq.poll();
        }
        int count = 0;
        while(count<2){
            count+=1;
            pq.poll();
        }
        return pq.poll();
    }
}