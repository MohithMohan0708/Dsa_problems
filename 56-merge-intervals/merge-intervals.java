class Pair{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(list.size()==0 || list.get(list.size()-1).end < intervals[i][0]){
                list.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            else{
                list.get(list.size()-1).end = Math.max(list.get(list.size()-1).end, intervals[i][1]);
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).start;
            ans[i][1] = list.get(i).end;
        }
        return ans;
    }
}