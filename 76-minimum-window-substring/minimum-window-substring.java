class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l = 0, r = 0, count = 0, minLen = Integer.MAX_VALUE,sIndex = -1;
        for(char ch : t.toCharArray()){
            hash[(int)ch]++;
        }
        while(r<s.length()){
            if(hash[(int)s.charAt(r)] > 0){
                count++;
            } 
            hash[(int)s.charAt(r)]--;
            while(count==t.length()){
                hash[(int)s.charAt(l)]++;
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                if(hash[(int)s.charAt(l)]>0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "":s.substring(sIndex,sIndex+minLen);
    }
}