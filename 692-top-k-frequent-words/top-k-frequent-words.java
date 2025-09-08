class Pair{
    String word;
    int count;
    Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.count!=b.count){
                return b.count-a.count;
            }
            else{
                return a.word.compareTo(b.word);
            }
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Pair(word,count));
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            Pair p = pq.poll();
            ans.add(p.word);
        }
        return ans;
    }
}