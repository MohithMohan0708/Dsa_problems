class Solution {
    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    public String sortVowels(String s) {
        List<Character> vowelList = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                vowelList.add(ch);
            }
        }
        Collections.sort(vowelList);
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                sb.append(vowelList.get(start));
                start++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}