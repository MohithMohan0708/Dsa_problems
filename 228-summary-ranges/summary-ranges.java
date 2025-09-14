class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<Pair> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(nums.length == 1){
            res.add(Integer.toString(nums[0]));
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            if(ans.size()==0 || ans.get(ans.size()-1).second+1 != nums[i]){
                ans.add(new Pair(nums[i],nums[i]));
            }
            if(ans.get(ans.size()-1).second+1 == nums[i]){
                ans.get(ans.size()-1).second = nums[i];
            }
        }
        for(int i = 0; i < ans.size(); i++){
            Pair p = ans.get(i);
            int start = p.first;
            int end = p.second;
            if(start == end){
                String temp = Integer.toString(start);
                res.add(temp);
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toString(start));
                sb.append("->");
                sb.append(Integer.toString(end));
                res.add(sb.toString());
            }
        }
        return res;
    }
}