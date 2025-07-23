class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        StringBuilder sb = new StringBuilder(s);
        if (x > y) {
            String[] result1 = getScore(sb, "ab", x);
            score += Integer.parseInt(result1[0]);
            sb = new StringBuilder(result1[1]);

            String[] result2 = getScore(sb, "ba", y);
            score += Integer.parseInt(result2[0]);
        } else {
            String[] result1 = getScore(sb, "ba", y);
            score += Integer.parseInt(result1[0]);
            sb = new StringBuilder(result1[1]);

            String[] result2 = getScore(sb, "ab", x);
            score += Integer.parseInt(result2[0]);
        }

        return score;
    }

    public String[] getScore(StringBuilder sb, String pair, int score) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < sb.length(); i++) {
            char curr = sb.charAt(i);
            if (!stack.isEmpty() && stack.peek() == pair.charAt(0) && curr == pair.charAt(1)) {
                stack.pop();
                res += score;
            } else {
                stack.push(curr);
            }
        }
        StringBuilder updatedSb = new StringBuilder();
        for (char c : stack) {
            updatedSb.append(c);
        }

        String[] ans = new String[2];
        ans[0] = Integer.toString(res);        
        ans[1] = updatedSb.toString();          
        return ans;
    }
}