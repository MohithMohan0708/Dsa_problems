class Solution {
    public int[] sumZero(int n) {
        if(n==1){
            return new int[]{0};
        }
        List<Integer> ans = new ArrayList<>();
        if(n%2!=0){
            ans.add(0);
        }
        for(int i = n ; ans.size() < n; i--){
            ans.add(i);
            ans.add(-i);
        }
        int len = ans.size();
        int[] res = new int[len];
        for(int i=0; i < len; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}