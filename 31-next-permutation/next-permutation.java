class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for(int i = n-2;i >= 0; i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1) {
            reverseArray(nums,0,n-1);
            return;
        }    
        for(int i = n - 1; i >= 0; i--){
            if(nums[i]>nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        reverseArray(nums,index+1,n-1);
    }
    public void reverseArray(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start+=1;
            end-=1;
        }
    }
}