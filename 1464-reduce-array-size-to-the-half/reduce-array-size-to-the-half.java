class Pair{
    int num, count;
    Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
}
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->
            Integer.compare(b.count,a.count)
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Pair(num,count));
        }
        int curr = 0;
        int ans = 0;
        while(curr < arr.length/2){
            Pair p = pq.poll();
            curr += p.count;
            ans+=1;
        }
        return ans;
    }
}