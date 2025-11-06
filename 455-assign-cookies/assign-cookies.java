class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int glen = g.length;
        int slen = s.length;
        int count = 0;
        while(i<glen && j<slen){
            if(s[j]>=g[i]){
                count+=1;
                i+=1;
                j+=1;
            }
            else{
                j+=1;
            }
        }
        return count;
    }
}