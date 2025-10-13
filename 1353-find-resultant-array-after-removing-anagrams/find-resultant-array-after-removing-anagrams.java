class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        for(String word: words){
            ans.add(word);
        }
        if(ans.size() == 1) return ans;
        int start = 1; 
        while(start<ans.size()){
            if(isAnagram(ans.get(start),ans.get(start-1))){
                ans.remove(start);
            }
            else{
                start+=1;
            }
        }
        return ans;
    }
    public boolean isAnagram(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        String sn1 = new String(ch1);
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);
        String sn2 = new String(ch2);
        return sn1.equals(sn2);
    }
}