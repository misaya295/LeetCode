package 蓝桥杯.第十届;

import java.util.*;

/*


DDDDLLULLLLLLDLLLLDDDRDDLDDDDDDDDDDDDLDLDLLULLUULLDDDDLDLLLLLULLLDLLDDDLLLLUU
LUUUUUUURURRUUUULLLLUURRRUUUURRUUURUULLULLULULLLDLDLLLLDLDLDDRRRDDLLDDLDDRDDD
RRDDRRRDRDDDRDDLLLLLLLLLDDDDDDLL



DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDRDRRURRUURRDDDDRDRRRRRURRRDRRDDDRRRRU
URUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDRDRRRRDRDRDDLLLDDRRDDRDDLD
DDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR


 */

class Main5 {


    static class PII {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int N = 100;
//    static int n=30,m=50;
    static int n = 4, m = 6;
    static char[][] g = new char[N][N];
    static PII[] q = new PII[N * N];
    static int[][] d = new int[N][N];
    static char[] w= {'D','L','R','U'};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            g[i] = sc.next().toCharArray();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }


        PII end = new PII(0, 0);
        PII start = new PII(n-1, m-1);
        System.out.println(bfs(start, end));

        int x = 0, y = 0;
        String res = "";
        while (x != n - 1 || y != m - 1) {


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (g[nx][ny] != '0') continue;

                if (d[x][y] == d[nx][ny] + 1) {
                    x= nx;
                    y = ny;
                    res += w[i];
                }

            }

        }
        System.out.println(res);



    }

    static int bfs(PII start, PII end) {



        int hh = 0, tt = 0;
        q[0] = start;
        d[start.x][start.y] = 0;

        while (hh <= tt) {

            PII t = q[hh++];
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];

                if (a < 0 || a >= n || b < 0 || b >= m) continue;
                if (g[a][b] == '1') continue;
                if (d[a][b] != -1) continue;
                d[a][b] = d[t.x][t.y] + 1;

                if (a == end.x && b == end.y) {
                    return d[a][b];
                }
                q[++tt] = new PII(a, b);
            }

        }

        return -1;


    }

}


//public class Main5 {
//    static int m,n;
//    static final int max=105;
//    static int[][] dist=new int[30][50];        //记录每个坐标到[n-1][m-1]的距离
//    static char map[][]=new char[max][max];
//    static char dir[]= {'D','L','R','U'};
//    static int dx[]={1,0,0,-1};     //四个方向
//    static int dy[]={0,-1,1,0};
//    static Queue<node9> q=new ArrayDeque<node9>();      //队列
//
//   static class node9{
//        int x;
//        int y;
//    }
//    public static void bfs(){       //求最短距离
//
//
//        dist[n-1][m-1]=0;       //初始化
//        node9 t=new node9();  //实例化一个对象，有两个属性，坐标行和列
//        t.x=n-1; t.y=m-1;
//        q.offer(t);     //入队
//
//        while(!q.isEmpty()){    //为空，求出了每个坐标到[n-1][m-1]的距离
//
//            t=q.poll();     //出队
//
//            for(int i=0;i<4;i++){       //四个方向查找
//
//                int xx=t.x+dx[i];
//                int yy=t.y+dy[i];
//
//                //dist[][]数组初始化为-1,看这个坐标有没有找过
//                if(xx>=0 && xx<n && yy>=0 && yy<m && dist[xx][yy]==-1 && map[xx][yy]=='0')
//                {
//
//                    dist[xx][yy]=dist[t.x][t.y]+1;
//                    node9 s=new node9();
//                    s.x=xx;
//                    s.y=yy;
//                    q.offer(s);     //入队
//
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n=sc.nextInt();
//        m=sc.nextInt();
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                dist[i][j]=-1;
//            }
//        }
//
//        for(int i=0;i<n;i++) {
//            String str=sc.next();
//            for(int j=0;j<m;j++) {
//                map[i][j]=str.charAt(j);
//            }
//        }
//
//        bfs();
//        System.out.println(dist[0][0]);  //坐标[0][0]到坐标[n-1][m-1]的最短距离
//
//        int x=0,y=0;
//        String res="";
//        while(x!=n-1 || y!=m-1) {    //从[0][0]出发，到达[n-1][m-1],结束查找
//
//            for(int i=0;i<4;i++) {
//
//                int xx=dx[i]+x;
//                int yy=dy[i]+y;
//
//                if(xx>=0 && xx<n && yy>=0 && yy<m && map[xx][yy]=='0') {
//                    //看坐标[x][y]在bfs时，是从哪个坐标过来的，那就又走回去
//                    if(dist[x][y]==dist[xx][yy]+1) {
//                        x=xx;
//                        y=yy;
//                        res+=dir[i];
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//
//    }
//}
