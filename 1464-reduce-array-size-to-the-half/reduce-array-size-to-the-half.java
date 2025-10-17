class Pair{
    int item;
    int freq;
    Pair(int item, int freq){
        this.item = item;
        this.freq = freq;
    }
}
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int item : arr){
            map.put(item,map.getOrDefault(item,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int item = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new Pair(item,freq));
        }
        int n = arr.length;
        int count = 0;
        int curr = 0;
        while(curr<n/2){
            Pair p = pq.poll();
            int item = p.item;
            int freq = p.freq;
            curr+=freq;
            count+=1;
        }
        return count;
    }
}