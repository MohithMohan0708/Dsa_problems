class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int[] hash = new int[n+1];
        List<Integer> curr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            hash[nums[i]] += 1;
            if(hash[nums[i]] == 1){
                curr.add(nums[i]);
            }
        }
        ans.add(curr);
        int size = curr.size();
        while(size!=n){
            List<Integer> pres = new ArrayList<>();
            for(int i = 0; i < hash.length; i++){
                if(hash[i] > 1){
                    pres.add(i);
                    hash[i]-=1;
                }
            }
            size+=pres.size();
            ans.add(pres);
        }
        return ans;
    }
}