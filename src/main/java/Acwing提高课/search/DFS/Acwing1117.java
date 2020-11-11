package Acwing提高课.search.DFS;




/*
1117. 单词接龙
   题目
   提交记录
   讨论
   题解
   视频讲解

单词接龙是一个与我们经常玩的成语接龙相类似的游戏。

现在我们已知一组单词，且给定一个开头的字母，要求出以这个字母开头的最长的“龙”，每个单词最多被使用两次。

在两个单词相连时，其重合部分合为一部分，例如 beast 和 astonish ，如果接成一条龙则变为 beastonish。

我们可以任意选择重合部分的长度，但其长度必须大于等于1，且严格小于两个串的长度，例如 at 和 atide 间不能相连。

输入格式
输入的第一行为一个单独的整数 n 表示单词数，以下 n 行每行有一个单词（只含有大写或小写字母，长度不超过20），输入的最后一行为一个单个字符，表示“龙”开头的字母。

你可以假定以此字母开头的“龙”一定存在。

输出格式
只需输出以此字母开头的最长的“龙”的长度。

数据范围
n≤20
输入样例：
5
at
touch
cheat
choose
tact
a
输出样例：
23
提示
连成的“龙”为 atoucheatactactouchoose。

难度：简单
时/空限制：1s / 64MB
总通过数：932
总尝试数：1295
来源：《信息学奥赛一本通》 , NOIP2000普及组 , NOIP2000提高组
算法标签

 */
import java.util.Scanner;
public class Acwing1117 {
    static int N = 21;
    static int n;
    static String[] word = new String[N];
    static int[][] g = new int[N][N];//表示i位置子符串与j位置子符串拼接重合的最小长度
    static int[] used = new int[N]; //i位置的字符串的使用次数
    static int res = 0;
    //dragon表示当前的单词龙,last表示上一个连接到字符串的单词
    static void dfs(String dragon,int last)
    {
        res = Math.max(dragon.length(), res);

        for(int i = 0;i < n;i ++)
        {
            if(g[last][i] > 0 && used[i] < 2)
            {
                int k = g[last][i];
                used[i] ++;
                dfs(dragon + word[i].substring(k),i);
                used[i] --;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0;i < n;i ++) word[i] = scan.next();
        String start = scan.next();
        //预处理
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < n;j ++)
            {
                String a = word[i];
                String b = word[j];
                for(int k = 1;k < Math.min(a.length(), b.length());k ++)
                {
                    int lenA = a.length() ;
                    int lenB = b.length() ;
                    if(a.substring(lenA - k, lenA).equals(b.substring(0, k)))
                    {
                        g[i][j] = k;
                        break;
                    }
                }
            }

        for(int i = 0;i < n;i ++)
        {
            //若该单词的第一字母和start相同
            if(word[i].substring(0, 1).equals(start))
            {
                used[i] ++;//表示该单词已使用一次
                dfs(word[i],i);
                used[i] --;
            }
        }
        System.out.println(res);
    }
}
