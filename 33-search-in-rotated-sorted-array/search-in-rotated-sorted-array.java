class Solution {
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; 
    }

    public int binarySearch(int start, int end, int[] nums, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);

        if(nums[pivot] == target) return pivot;

        if(target >= nums[pivot] && target <= nums[n - 1]){
            return binarySearch(pivot, n - 1, nums, target);
        } else {
            return binarySearch(0, pivot - 1, nums, target);
        }
    }
}
