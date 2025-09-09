class Solution {
    public int findPeak(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start<end){
            int mid = start + (end-start) / 2;
            if(nums[mid]>nums[end]){ // decreasing part
                start = mid + 1;
            }
            else if(nums[mid]<nums[mid+1]){ // increasing part
                end = mid;
            }
        }
        return start;
    }
    public int findMin(int[] nums) {
        int peak = findPeak(nums);
        return nums[peak];
    }
}