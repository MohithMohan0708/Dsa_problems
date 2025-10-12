class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans = new int[2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(count==2){
                ans[i] = num;
                i+=1;
            }
        }
        return ans;
    }
}