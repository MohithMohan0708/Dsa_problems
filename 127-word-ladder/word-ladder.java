class Pair{
    String word;
    int dist;
    Pair(String word, int dist){
        this.word = word;
        this.dist = dist;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().dist;
            q.remove();
            if(word.equals(endWord)) return steps;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] currArray = word.toCharArray();
                    currArray[i] = ch;
                    String curr = new String(currArray);
                    if(set.contains(curr)){
                        q.offer(new Pair(curr,steps+1));
                        set.remove(curr);
                    }
                }
            }
        }
        return 0;
    }
}