class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int l = 0, r = 0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r<n){
            char c = num.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>1){
                char cin = num.charAt(l);
                map.put(cin,map.get(cin)-1);
                if(map.get(cin) == 0){
                    map.remove(cin);
                }
                l++;
            }
            if(map.size()==1){
                Map.Entry<Character,Integer> entry = map.entrySet().iterator().next();
                char ch = entry.getKey();
                int val = entry.getValue();
                if(val>=3){
                    int number = ch - '0';
                    if(number>maxi){
                        maxi = number;
                    }
                }
            }
            r++;
        }
        if(maxi == Integer.MIN_VALUE){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String temp = Integer.toString(maxi);
        sb.append(temp);
        sb.append(temp);
        sb.append(temp);
        return sb.toString();
    }
}