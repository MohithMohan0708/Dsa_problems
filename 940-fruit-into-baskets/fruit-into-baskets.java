class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = fruits.length;
        int l = 0;
        int maxLen = 0;
        for(int r = 0; r < n; r++){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l+=1;
            }
            if(map.size()<=2){
                maxLen = Math.max(maxLen,r-l+1);
            }
        }
        return maxLen;
    }
}