class Pair{
    int count; int element;
    Pair(int count, int element){
        this.count = count;
        this.element = element;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.count-a.count));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Pair(count,element));
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            Pair p = pq.poll();
            ans[i] = p.element;
        }
        return ans;
    }
}