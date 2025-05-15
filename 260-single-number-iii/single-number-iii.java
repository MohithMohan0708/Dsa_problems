class Solution {
    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }
        int bit = ans & (-ans);
        int a = 0,b = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i]&bit)==0){
                a ^= nums[i];
            }
            else{
                b ^= nums[i];
            }
        }
        return new int[]{a,b};
    }
}