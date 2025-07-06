class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        for(char ch: text.toCharArray()){
            hash[ch-'a'] += 1;
        }
        int count = 0;
        while(hash[0]>0 && hash[1]>0 && hash[11]>=2 && hash[14]>=2 && hash[13]>0){
            count += 1;
            hash[0]--;
            hash[1]--;
            hash[11]-=2;
            hash[14]-=2;
            hash[13]--;
        }
        return count;
    }
}