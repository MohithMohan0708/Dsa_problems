class Pair{
    int score, index;
    Pair(int score, int index){
        this.score = score;
        this.index = index;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.score,a.score));
        for(int i = 0; i < score.length; i++){
            pq.offer(new Pair(score[i],i));
        }
        String[] ans = new String[score.length];
        String[] temp = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = pq.size();
        int count = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(count<3){
                int index = p.index;
                ans[index] = temp[count];
                count++;
            }
            else{
                int index = p.index;
                ans[index] = Integer.toString(count+1);
                count++;
            }
        }
        return ans;
    }
}