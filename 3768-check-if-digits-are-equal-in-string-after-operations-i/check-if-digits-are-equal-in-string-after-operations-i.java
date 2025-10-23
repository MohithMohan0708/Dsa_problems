class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length()==2){
            return s.charAt(0) == s.charAt(1);
        }
        while(s.length()>2){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length()-1; i++){
                int first = s.charAt(i)-'0';
                int second = s.charAt(i+1)-'0';
                int temp = (first+second)%10;
                char temp1 = (char)(temp+'0');
                sb.append(temp1);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}