class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] hash = new int[51];
        int n = A.length;
        int[] ans = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            hash[A[i]]+=1;
            hash[B[i]]+=1;
            if(hash[A[i]] == 2){
                count+=1;
                hash[A[i]] = 0;
            }
            if(hash[B[i]] == 2){
                count+=1;
                hash[B[i]] = 0;
            }
            ans[i] = count;
        }
        return ans;
    }
}