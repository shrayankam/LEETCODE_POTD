class Solution {

    public boolean isSafe(int row, int col, char[][] board, int n) {

        int rowN = row;
        int colN = col;
        while (colN >= 0) {
            if (board[rowN][colN] == 'Q') {
                return false;
            }
            colN--;
        }

        rowN = row;
        colN = col;
        while (colN >= 0 && rowN >= 0) {
            if (board[rowN][colN] == 'Q') {
                return false;
            }
            colN--;
            rowN--;
        }

        rowN = row;
        colN = col;
        while (colN >= 0 && rowN < n) {
            if (board[rowN][colN] == 'Q') {
                return false;
            }
            colN--;
            rowN++;
        }

        return true;
    }

    public void solve(int col, char[][] board,
                      List<List<String>> ans, int n) {

        if (col == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                solve(col + 1, board, ans, n);

                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, board, ans, n);
        return ans;
    }
}