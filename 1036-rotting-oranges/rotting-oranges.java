import java.util.*;

class Pair {
    int row, col, time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
            }
        }

        int tm = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;
            int t = curr.time;

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {

                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if (nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    grid[nRow][nCol] == 1 &&
                    vis[nRow][nCol] != 2) {

                    q.add(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && vis[i][j] != 2) {
                    return -1;
                }
            }
        }

        return tm;
    }
}