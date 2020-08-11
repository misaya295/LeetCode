package leetcode.力扣题.题130;

class Solution {

    int m = 0;
    int n = 0;
    public void solve(char[][] board) {

        /*
        行数
         */
        m = board.length;
        /*
         *列数
         */
        if (m == 0) {
            return;
        }
        n = board[0].length;



        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {

                DFS(board, 0, i);  //第一行
            }
            if (board[m - 1][i] == 'O') {

                DFS(board, m - 1, i);//最后一行}
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                DFS(board, i,0 );

            }
            if (board[i][n-1] == 'O') {
                DFS(board, i, n-1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'X') {
                    continue;
                } else {
                    board[i][j] = 'X';
                }

            }
        }

    }

    public void DFS(char[][] board, int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'M';
        DFS(board, x - 1, y);
        DFS(board, x + 1, y);
        DFS(board, x, y - 1);
        DFS(board, x, y + 1);


    }

}
