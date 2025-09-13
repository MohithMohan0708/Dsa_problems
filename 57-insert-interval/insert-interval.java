class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n == 0){
            if(newInterval.length != 0){
                int[][] res = new int[1][2];
                res[0][0] = newInterval[0];
                res[0][1] = newInterval[1];
                return res;
            }
        }
        ArrayList<Pair> ans = new ArrayList<>();
        
        boolean inserted = false;
        
        for(int i = 0; i < n; i++){
            if(intervals[i][1] < newInterval[0]){
                ans.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else if(intervals[i][0] > newInterval[1]){
                if(!inserted){
                    ans.add(new Pair(newInterval[0], newInterval[1]));
                    inserted = true;
                }
                ans.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        if(!inserted){
            ans.add(new Pair(newInterval[0], newInterval[1]));
        }
        
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i).first;
            res[i][1] = ans.get(i).second;
        }
        return res;
    }
}
