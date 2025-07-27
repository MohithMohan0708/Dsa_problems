class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public void combinSum(int[] arr, int i, List<Integer> combin, List<List<Integer>> ans, int target){
        if(target<0 || i == arr.length) return;
        if(target==0){
            List<Integer> temp = new ArrayList<>(combin);
            Collections.sort(temp);
            if(!set.contains(temp)){
                set.add(temp);
                ans.add(temp);
            }
            return;
        }
        combin.add(arr[i]);
        //include
        combinSum(arr,i+1,combin,ans,target-arr[i]);
        //multiple include
        combinSum(arr,i,combin,ans,target-arr[i]);
        //exclude
        combin.remove(combin.size()-1);
        combinSum(arr,i+1,combin,ans,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        combinSum(candidates,0,combin,ans,target);
        return ans;
    }
}