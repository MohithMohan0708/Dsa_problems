import java.util.HashMap;

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair other = (Pair) o;
        return this.i == other.i && this.j == other.j;
    }

    @Override
    public int hashCode() {
        return 31 * i + j;
    }
}

class Solution {
    public boolean func(int i, int j, String s, String p, HashMap<Pair, Boolean> map) {
        Pair key = new Pair(i, j);

        if (i < 0 && j < 0) {
            map.put(key, true);
            return true;
        }
        if (i < 0 && j >= 0) {
            map.put(key, false);
            return false;
        }
        if (j < 0 && i >= 0) {
            for (int start = 0; start <= i; start++) {
                if (s.charAt(start) != '*') {
                    map.put(key, false);
                    return false;
                }
            }
            map.put(key, true);
            return true;
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') {
            boolean curr = func(i - 1, j - 1, s, p, map);
            map.put(key, curr);
            return curr;
        }

        if (s.charAt(i) == '*') {
            boolean curr = func(i - 1, j, s, p, map) || func(i, j - 1, s, p, map);
            map.put(key, curr);
            return curr;
        }

        map.put(key, false);
        return false;
    }

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        HashMap<Pair, Boolean> map = new HashMap<>();
        return func(m - 1, n - 1, p, s, map);
    }
}
