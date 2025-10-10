class Solution {
    public double[] sampleStats(int[] arr) {
    double[] ans = new double[5];
    int min = -1, max = -1, mode = 0, maxFreq = 0;
    long total = 0, sum = 0;

    for (int i = 0; i < 256; i++) {
        if (arr[i] > 0) {
            if (min == -1) min = i;
            max = i;
            sum += (long) i * arr[i];
            total += arr[i];
            if (arr[i] > maxFreq) {
                maxFreq = arr[i];
                mode = i;
            }
        }
    }

    int mid1 = (int)((total + 1) / 2);
    int mid2 = (int)((total % 2 == 0) ? (total / 2 + 1) : mid1);
    int curr = 0, left = -1, right = -1;

    for (int i = 0; i < 256; i++) {
        curr += arr[i];
        if (curr >= mid1 && left == -1) left = i;
        if (curr >= mid2) {
            right = i;
            break;
        }
    }

    ans[0] = (double) min;
    ans[1] = (double) max;
    ans[2] = (double) sum / total;
    ans[3] = (left + right) / 2.0;
    ans[4] = (double) mode;

    return ans;
}
}