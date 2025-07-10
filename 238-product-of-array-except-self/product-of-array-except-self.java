class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forProd = new int[n];
        int[] bacProd = new int[n];
        int[] ans = new int[n];
        forProd[0] = nums[0];
        for(int i = 1; i < n; i++){
            forProd[i] = nums[i]*forProd[i-1];
        }   
        bacProd[n-1] = nums[n-1];
        for(int i = n-2; i >=0; i--){
            bacProd[i] = nums[i]*bacProd[i+1];
        }
        for(int i = 0; i < n; i++){
            if(i==0){
                ans[i] = bacProd[i+1];
            }
            else if(i==n-1){
                ans[i] = forProd[i-1];
            }
            else{
                ans[i] = forProd[i-1]*bacProd[i+1];
            }
        }
        return ans;
    }
}