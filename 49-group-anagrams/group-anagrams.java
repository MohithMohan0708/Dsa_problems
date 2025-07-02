class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>();
       List<List<String>> ans = new ArrayList<>();
       for(String s: strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)){
               map.get(temp).add(s);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp,list);
            }
       }
       for(List<String> l : map.values()){
            ans.add(l);
       }   
       return ans;
    }
}