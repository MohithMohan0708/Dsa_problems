class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void genSubsets(int i, List<Integer> curr, int n, int[] nums){
        if(i==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        genSubsets(i+1,curr,n,nums);
        curr.add(nums[i]);
        genSubsets(i+1,curr,n,nums);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> curr = new ArrayList<>();
        genSubsets(0,curr,n,nums);
        return ans;
    }
}