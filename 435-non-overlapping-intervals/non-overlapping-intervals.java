class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        List<Pair> ans = new ArrayList<>();
        int count = 0;

        for (int[] interval : intervals) {
            if (ans.size() == 0 || interval[0] >= ans.get(ans.size() - 1).second) {
                ans.add(new Pair(interval[0], interval[1]));
            } else {
                count++;
            }
        }

        return count;
    }
}