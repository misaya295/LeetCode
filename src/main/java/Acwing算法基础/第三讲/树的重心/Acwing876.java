package Acwing算法基础.第三讲.树的重心;

import java.util.*;
public class Acwing876{

    static int N=100010;
    static int M = N *2;
    static int n;
    static int ans= N;
    static int[] h = new int[N];
    static int[] e= new int[M];
    static int[] ne= new int[M];
    static int idx;
    static boolean[] st= new boolean[N];
    static   void add(int a,int b){
        e[idx]=  b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static  int dfs(int u){
        st[u] = true;
        int size =0,sum=0;
        for(int i=h[u];i != -1;i= ne[i]){

            int j =e[i];
            if(st[j]) continue;
            int s = dfs(j);
            size = Math.max(size,s);
            sum +=s;
        }

        size = Math.max(size,n-sum-1);
        ans= Math.min(ans,size);
        return sum +1;

    }


    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        n =sc.nextInt();
        Arrays.fill(h,-1);
        for(int i=0;i< n-1;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
}
