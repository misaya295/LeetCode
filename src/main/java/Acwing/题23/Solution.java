package Acwing.题23;


/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。

路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。

如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。

注意：

输入的路径不为空；
所有出现的字符均为大写英文字母；
样例
matrix=
[
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
]

str="BCCE" , return "true"

str="ASAE" , return "false"
 */
class Solution {

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public boolean hasPath(char[][] matrix, String str) {

        for(int i =0;i < matrix.length;i++){

            for(int j =0 ; j < matrix[0].length;j++){
                if(dfs(matrix,0,str,i,j)) return true;
            }
        }

        return false;



    }

    static boolean dfs(char[][] matrix, int u,String str,int x,int y){

        if(u == matrix.length) return true;
        if(matrix[x][y] != str.charAt(u)) return false;
        char t = matrix[x][y];
        matrix[x][y] = '*';
        for(int i=0;i < 4;i++) {
            int  a = dx[i] + x;
            int  b = dy[i] + y;
            if(a  >= 0 && a  < matrix.length && b >=0 && b < matrix[0].length) {
                if(dfs(matrix,u+1,str,a,b)) return true;
            }
        }
        matrix[x][y] = t;

        return false;

    }

}