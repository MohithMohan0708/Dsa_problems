class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<n){
            if(map.containsKey(nums[r])){
                while(map.containsKey(nums[r])){
                    sum -= nums[l];
                    map.remove(nums[l]);
                    l++;
                }
            }
            sum += nums[r];
            maxi = Math.max(sum,maxi);
            map.put(nums[r],1);
            r++;
        }   
        return maxi;
    }
}