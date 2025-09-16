class Pair{
    int number;
    int index;
    Pair(int number, int index){
        this.number = number;
        this.index = index;
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.number==b.number){
                return Integer.compare(a.index,b.index);
            }
            else{
                return Integer.compare(a.number,b.number);
            }
        });
        for(int i = 0; i < n; i++){
            pq.offer(new Pair(nums[i],i));
        }
        while(k-- > 0){
            Pair p = pq.poll();
            p.number *= multiplier;
            pq.offer(new Pair(p.number,p.index));
        }
        int[] ans = new int[n];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[p.index] = p.number;
        }
        return ans;
    }
}