package leetcode.力扣题.题79;


import com.sun.org.apache.regexp.internal.RE;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    public boolean exist(char[][] board, String word) {
         n = board.length;
         m = board[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 1, visited)) {
                        return true;

                    }
                }


            }
        }
        return false;

    }


    public static boolean dfs(char[][] board,String word,int x ,int y,int k,int[][] visited) {
        if (k >= word.length()) {
            return true;
        }
        visited[x][y] = 1;
        for (int a = 0; a < 4; a++) {
            int newx = x + dx[a];
            int newy = y + dy[a];

            if (newx >= 0 && newx < n && newy >= 0 && newy < m && visited[newx][newy] == 0) {
                if (board[newx][newy] == word.charAt(k)) {
                    if (dfs(board, word, newx, newy, k + 1, visited)) {
                        return true;
                    }
                }
            }
        }
        visited[x][y] = 0;
        return false;
    }
}