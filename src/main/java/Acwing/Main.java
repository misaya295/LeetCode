package Acwing;

import java.util.*;
class Main{
    static int N=20;
    static int n;
    static boolean[] st = new boolean[N];
    static boolean[] backup = new boolean[N];
    static int ans;


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        dfs_a(0,0);

        System.out.println(ans);

    }

    static void dfs_a(int u,int a){
        if(a >= n || u >9) return;
        if(a > 0) dfs_c(u,a,0);
        for(int i =1;i<= 9;i++){
            if(!st[i]){
                st[i] = true;
                dfs_a(u+1, a*10+i);
                st[i] = false;
            }
        }
    }


    static void dfs_c(int u,int a,int c){
        if(u > 9)  return;
        if(check(a,c)) {
            ans++;
            return;
        }
        for(int i =1;i <= 9;i++){
            if(!st[i]){
                st[i] = true;
                dfs_c(u+1,a,c* 10 + i);
                st[i] = false;
            }
        }
    }



    static boolean check(int a,int c){
        long b= (long)c * n - a*c;
        if(a == 0|| b ==0 || c== 0) return false;
        backup = Arrays.copyOf(st,st.length);
        while(b > 0){
            int x = (int) (b%10);
            b/=10;
            if(x == 0|| backup[x]) return false;
            backup[x] = true;
        }


        for(int i=1;i<= 9;i++){
            if(!backup[i]) return false;
        }

        return true;




    }








}