class Solution {
    public String removeDuplicateLetters(String s) {
        int hash[] = new int[27];
        for(char ch : s.toCharArray()){
                hash[ch-'a']++;
        }
        boolean vis[] = new boolean[27];
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            hash[ch-'a']--;
            if(vis[ch-'a']) continue;
            while(!st.isEmpty() && st.peek()>ch && hash[st.peek()-'a']>0){
                vis[st.pop()-'a'] = false;
            }
            st.push(ch);
            vis[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}