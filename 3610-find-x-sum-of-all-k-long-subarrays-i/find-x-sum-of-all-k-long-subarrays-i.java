class Pair {
    int num, count;
    Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public int get_xsum(int[] nums, int start, int end, int x) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
        if (a.count != b.count) {
            return Integer.compare(b.count, a.count); 
        } else {
            return Integer.compare(b.num, a.num); 
        }
    });

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = start; i < end; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        pq.offer(new Pair(entry.getKey(), entry.getValue()));
    }

    int sum = 0;
    while (x-- > 0 && !pq.isEmpty()) {
        Pair p = pq.poll();
        sum += p.num * p.count;
    }

    return sum;
}

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        if (k == x) {
            for (int i = 0; i + k <= n; i++) {
                int sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += nums[j];
                }
                ans[i] = sum;
            }
        } else {
            for (int i = 0; i + k <= n; i++) {
                ans[i] = get_xsum(nums, i, i + k, x);
            }
        }

        return ans;
    }
}