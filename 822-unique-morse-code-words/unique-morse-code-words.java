class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character,String> map = new HashMap<>();
        String[] morseCodes = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        for (int i = 0; i < morseCodes.length; i++) {
            char letter = (char) ('a' + i);
            map.put(letter, morseCodes[i]);
        }
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char ch : word.toCharArray()){
                sb.append(map.get(ch));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}