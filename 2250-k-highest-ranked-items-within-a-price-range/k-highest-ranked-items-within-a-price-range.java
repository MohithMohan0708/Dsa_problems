import java.util.*;

class Pair {
    int row, col, dist;
    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Quad {
    int dist, price, row, col;
    Quad(int dist, int price, int row, int col) {
        this.dist = dist;
        this.price = price;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        PriorityQueue<Quad> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.price != b.price) return a.price - b.price;
            if (a.row != b.row) return a.row - b.row;
            return a.col - b.col;
        });

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start[0], start[1], 0));
        vis[start[0]][start[1]] = true;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row, col = p.col, dist = p.dist;

            if (grid[row][col] >= pricing[0] && grid[row][col] <= pricing[1] && grid[row][col] > 1) {
                pq.offer(new Quad(dist, grid[row][col], row, col));
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                    !vis[nrow][ncol] && grid[nrow][ncol] != 0) {
                    vis[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol, dist + 1));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < k) {
            Quad cur = pq.poll();
            ans.add(Arrays.asList(cur.row, cur.col));
        }
        return ans;
    }
}
