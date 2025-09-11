class Solution {
    public long getSum(int[] candies) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    public int maximumCandies(int[] candies, long k) {
        long total = getSum(candies);
        if (total < k) {
            return 0;
        }
        long l = 1;
        long r = total / k;
        long res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
                if (count >= k) {
                    break;
                }
            }
            if (count >= k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) res;
    }
}