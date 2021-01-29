package Acwing.题429;


/*
某小学最近得到了一笔赞助，打算拿出其中一部分为学习成绩优秀的前5名学生发奖学金。

期末，每个学生都有3门课的成绩:语文、数学、英语。

先按总分从高到低排序，如果两个同学总分相同，再按语文成绩从高到低排序，如果两个同学总分和语文成绩都相同，那么规定学号小的同学排在前面，这样，每个学生的排序是唯一确定的。

任务：先根据输入的3门课的成绩计算总分，然后按上述规则排序，最后按排名顺序输出前五名名学生的学号和总分。

注意，在前5名同学中，每个人的奖学金都不相同，因此，你必须严格按上述规则排序。

例如，在某个正确答案中，如果前两行的输出数据(每行输出两个数:学号、总分) 是:

7 279
5 279
这两行数据的含义是:总分最高的两个同学的学号依次是7号、5号。

这两名同学的总分都是279 (总分等于输入的语文、数学、英语三科成绩之和)，但学号为7的学生语文成绩更高一些。

如果你的前两名的输出数据是:

5 279
7 279
则按输出错误处理。

输入格式
输入文件包含n+1行:

第1行为一个正整数n，表示该校参加评选的学生人数。

第2到n+1行，每行有3个用空格隔开的数字，每个数字都在0到100之间，第j行的3个数字依次表示学号为j-1的学生的语文、数学、英语的成绩。

每个学生的学号按照输入顺序编号为1~n (恰好是输入数据的行号减1)。

所给的数据都是正确的，不必检验。

输出格式
输出文件共有5行，每行是两个用空格隔开的正整数，依次表示前5名学生的学号和总分。

数据范围
6≤n≤300
输入样例：
6
90 67 80
87 66 91
78 89 91
88 99 77
67 89 64
78 89 98
输出样例：
6 265
4 264
3 258
2 244
1 237
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num429 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i ++ ) {
            String[] s = in.readLine().split(" ");
            int ch = Integer.parseInt(s[0]);
            int math = Integer.parseInt(s[1]);
            int eng = Integer.parseInt(s[2]);
            students[i] = new Student(ch, math, eng, ch + math + eng, i + 1);
        }

        Arrays.sort(students);
        for (int i = 0; i < n && i < 5; i ++ ) {
            System.out.println(students[i].id + " " + students[i].total);
        }
    }

    private static class Student implements Comparable<Student>{
        int chinese, math, english;
        int total;
        int id;

        public Student(int chinese, int math, int english, int total, int id) {
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.total = total;
            this.id = id;
        }

        @Override
        public int compareTo(Student o) {
            if (this.total != o.total) return o.total - this.total;
            if (this.chinese != o.chinese) return o.chinese - this.chinese;
            return this.id - o.id;
        }
    }
}

