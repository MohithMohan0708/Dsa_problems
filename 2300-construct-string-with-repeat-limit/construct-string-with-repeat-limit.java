class Pair{
    char ch;
    int count;
    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.ch-a.ch);
        for(int i= 0; i < freq.length; i++){
            if(freq[i]>0){
                pq.offer(new Pair((char)(i+'a'),freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curr = Math.min(p.count,repeatLimit);
            for(int i = 0; i < curr; i++){
                sb.append(p.ch);
            }
            p.count -= curr;
            if(p.count>0){
                if(pq.isEmpty()) break;
                Pair next = pq.poll();
                sb.append(next.ch);
                next.count--;
                if(next.count>0) pq.offer(new Pair(next.ch,next.count));
                pq.offer(new Pair(p.ch,p.count));
            }
        }
        return sb.toString();
    }
}