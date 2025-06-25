class Solution {
    public String[] divideString(String s, int k, char fill) {
        int length = s.length();
        int toadd = (length % k);
        if(toadd!=0){
            for(int i = 0; i < k - toadd; i++){
                s += fill;
            }
        }
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < s.length(); i+=k){
            String res = "";
            res += s.substring(i,i+k);
            temp.add(res);
        }
        int clength = s.length() / k;
        String ans[] = new String[clength];
        for(int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}