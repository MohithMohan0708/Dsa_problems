class Solution {
    public void merge(int low, int mid, int high, int[] nums){
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid+1;
        int k = 0;
        while(left<=mid && right<=high){
            if(nums[left] <= nums[right]){
                temp[k] = nums[left];
                left++;
                k++;
            }
            else{
                temp[k] = nums[right];
                right++;
                k++;
            }
        }
        if(left > mid){
            while(right <= high){
                temp[k] = nums[right];
                k++;
                right++;
            }
        }
        else{
            while(left <= mid){
                temp[k] = nums[left];
                left++;
                k++;
            }
        }
        for(int i = low; i <= high; i++){
            nums[i] = temp[i-low];
        }
    }
    public int countPairs(int low, int mid, int high, int[] nums){
        int right = mid+1;
        int count = 0;
        for(int i = low; i <=mid; i++){
            while(right<=high && (long)nums[i] > 2L * nums[right]){
                right+=1;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    public int mergeSort(int low, int high, int[] nums){
        int count = 0;
        if(low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(low, mid, nums);
        count += mergeSort(mid+1, high, nums);
        count += countPairs(low, mid, high, nums);
        merge(low, mid, high, nums);
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(0,nums.length-1,nums);
    }
}