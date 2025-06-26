class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] nge = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            int getIndex = linearSearch(nums1[i],nums2);
            ans[i] = nge[getIndex]; 
        }
        return ans;
    }
    public int linearSearch(int target,int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}