class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n){
            int element = nums[i];
            int index = nums[i] - 1;
            if(index>=0 && index<n){
                if(nums[index]!=nums[i]){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }
            i++;
        }
        for(int j = 0; j < n; j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;
    }
}