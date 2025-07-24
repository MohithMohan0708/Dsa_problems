class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        HashMap<Character, Queue<String>> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.putIfAbsent(ch,new LinkedList<>());
        }
        for(String word: words){
            char c = word.charAt(0);
            if(map.containsKey(c)){
                map.get(c).offer(word);
            }
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Queue<String> q = map.get(c);
            int n = q.size();
            for(int j = 0; j < n; j++){
                String st = q.poll();
                if(st.substring(1).length()==0){
                    ans+=1;
                }
                else{
                    if(map.containsKey(st.charAt(1))){
                        map.get(st.charAt(1)).offer(st.substring(1));
                    }
                }
            }
        }
        return ans;
    }
}