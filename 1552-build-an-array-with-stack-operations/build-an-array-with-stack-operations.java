class Solution {
    public List<String> buildArray(int[] target, int n) {
        int start = 0;
        List<String> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 1; i <= n; i++){
            st.push(i);
            if(st.peek()==target[start]){
                ans.add("Push");
                start++;
            }
            else{
                ans.add("Push");
                ans.add("Pop");
                st.pop();
            }
            if(start==target.length){
                return ans;
            }
        }
        return ans;
    }
}