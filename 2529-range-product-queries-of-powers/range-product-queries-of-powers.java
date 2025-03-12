class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        ArrayList<Long> powers = new ArrayList<>();
        String str = Integer.toBinaryString(n);
        long pow = 1;
        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i)=='1') powers.add(pow);
            pow = pow * 2;
        }
        long mod = (long) 1e9 + 7;
        for(int i = 0 ; i < len; i++){
            long mul = 1;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                mul = (mul * powers.get(j)) % mod;
            }
            ans[i] = (int)mul;
        }
        return ans;
    }
}