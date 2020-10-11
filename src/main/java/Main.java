    import java.sql.SQLOutput;
    import java.util.*;
    class Main{


        public static void main(String[] args) {

             String a= "ulacfd";
             String b = "jizalu";
            int n= a.length();



            boolean flag=false;
            int j =n;
            for(int i =0;i <n; i++){
                String apre = a.substring(0, i);
                String asu = a.substring(i, n);
                String bpre = b.substring(0, i);
                String bsu = b.substring(i,n);
                System.out.println(apre + bsu);
                System.out.println(bpre + asu);

                }
            }




        }



