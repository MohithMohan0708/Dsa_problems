class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        for(int num : nums){
            if(num>maxi){
                maxi = num;
            }
        }
        int score = maxi;
        for(int i = 1; i < k; i++){
            score += maxi + i;
        }
        return score;
    }
}