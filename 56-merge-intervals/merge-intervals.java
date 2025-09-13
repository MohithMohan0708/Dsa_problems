class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<Pair> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ans.size()==0 || ans.get(ans.size()-1).second<intervals[i][0]){
                ans.add(new Pair(intervals[i][0],intervals[i][1]));
            }
            else{
                ans.get(ans.size()-1).second = Math.max(ans.get(ans.size()-1).second, intervals[i][1]);
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i).first;
            res[i][1] = ans.get(i).second;
        }
        return res;
    }
}