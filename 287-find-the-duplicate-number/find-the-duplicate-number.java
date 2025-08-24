class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n){
            int element = nums[i];
            int actual = nums[i] - 1;
            if (actual >=0 && actual<n){
                if(nums[actual]!=nums[i]){
                    int temp = nums[actual];
                    nums[actual] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }
            i++;
        }
        for(int j = 0; j < n; j++){
            if(nums[j]!=j+1){
                return nums[j];
            }
        }
        return 0;
    }
}