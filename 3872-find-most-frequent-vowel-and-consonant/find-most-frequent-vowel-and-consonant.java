class Solution {
    public boolean isVowel(char ch){
        return "aeiou".indexOf(ch)!=-1;
    }
    public int maxFreqSum(String s) {
        int n = s.length();
        if(n==0) return 0;
        int vmax = 0;
        int cmax = 0;
        HashMap<Character,Integer> vmap = new HashMap<>();
        HashMap<Character,Integer> cmap = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                vmap.put(ch,vmap.getOrDefault(ch,0)+1);
                if(vmax < vmap.get(ch)){
                    vmax = vmap.get(ch);
                }
            }
            else{
                cmap.put(ch,cmap.getOrDefault(ch,0)+1);
                if(cmax < cmap.get(ch)){
                    cmax = cmap.get(ch);
                }
            }
        }
        return vmax + cmax;
    }
}