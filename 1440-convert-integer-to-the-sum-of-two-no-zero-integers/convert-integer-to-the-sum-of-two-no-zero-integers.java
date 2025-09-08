class Solution {
    public boolean containsZero(int diff){
        String temp = Integer.toString(diff);
        int n = temp.length();
        for(char ch : temp.toCharArray()){
            if(ch =='0'){
                return true;
            }
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1; i <= n; i++){
            int curr = i;
            int diff = n - curr;
            if(!containsZero(diff) && !containsZero(curr)){
                ans[0] = curr;
                ans[1] = diff;
                return ans;
            }
        }
        return ans;
    }
}