class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        int j = 0;
        if(hlen<nlen) return -1;
        for(int i = 0; i < hlen; i++){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(i+nlen<=hlen){
                    String temp = haystack.substring(i,i+nlen);
                    if(temp.equals(needle)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}