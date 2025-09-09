class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if(nums[mid]>nums[mid+1]){ //we are in the decreasing part
                end = mid;
            }
            else{ //nums[mid]<nums[mid+1] i.e we are in the increasing part
                start = mid + 1;
            }
        }
        return start;
    }
}