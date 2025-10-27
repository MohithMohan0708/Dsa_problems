class Pair {
    int first, second, index;
    Pair(int first, int second, int index) {
        this.first = first;
        this.second = second;
        this.index = index;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(a.first + a.second, b.first + b.second)
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            List<Integer> curr = new ArrayList<>();
            curr.add(p.first);
            curr.add(p.second);
            ans.add(curr);

            if (p.index + 1 < nums2.length) {
                pq.offer(new Pair(p.first, nums2[p.index + 1], p.index + 1));
            }
        }

        return ans;
    }
}