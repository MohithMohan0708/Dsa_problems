class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);
       for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i]==nums[i-1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = nums.length - 1;
                while(k < l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k += 1;
                        l -= 1;
                        while(k < l && nums[k] == nums[k-1]) k+=1;
                        while(k < l && nums[l] == nums[l+1]) l-=1;
                    }
                    else if(sum < target){
                        k+=1;
                    }
                    else{
                        l-=1;
                    }
                }
            }
       } 
       return ans;
    }
}