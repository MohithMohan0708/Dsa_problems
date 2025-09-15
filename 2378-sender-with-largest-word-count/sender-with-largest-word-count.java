class Pair{
    int count;
    String sender;
    Pair(int count, String sender){
        this.count = count;
        this.sender = sender;
    }
}
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int curr = messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+curr);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.count == b.count){
                return b.sender.compareTo(a.sender);
            }
            else{
                return Integer.compare(b.count,a.count);
            }
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            String sender = entry.getKey();
            pq.offer(new Pair(count,sender));
        }
        Pair p = pq.poll();
        return p.sender;
    }
}