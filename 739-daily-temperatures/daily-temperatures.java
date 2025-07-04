class Pair{
    int num;
    int index;
    Pair(int num, int index){
        this.num = num;
        this.index = index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
     int[] ans = new int[temperatures.length];
     Stack<Pair> st = new Stack<>();
     for(int i = temperatures.length-1; i >= 0; i--){
        while(!st.isEmpty() && st.peek().num <= temperatures[i]){
            st.pop();
        }
        if(st.isEmpty()) ans[i] = 0;
        else{
            ans[i] = st.peek().index - i;
        }
        st.push(new Pair(temperatures[i], i));
     }   
     return ans;
    }
}