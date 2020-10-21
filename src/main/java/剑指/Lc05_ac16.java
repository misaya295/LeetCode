package 剑指;

/*
请实现一个函数，把字符串中的每个空格替换成"%20"。

你可以假定输入字符串的长度最大是1000。
注意输出字符串的长度可能大于1000。

样例
输入："We are happy."

输出："We%20are%20happy."
 */
public class Lc05_ac16 {

    public String replaceSpaces(StringBuffer s) {
        int len = s.length();


        char[] array = new char[len * 3];

        int size = 0;
        for (int i = 0; i < len; i++) {


            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';

            } else {
                array[size++] = c;
            }


        }

        String newstr = new String(array, 0, size);
        return newstr;
    }
}
