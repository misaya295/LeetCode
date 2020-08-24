package 腾讯笔试;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        String s = ")([]]([(](])))([]()()]([][[)[()[)]([[(])][][[[([)]";
        System.out.println(check(s));
    }


    public  static int check(String s) {

        int n = s.length();


        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!pairs.containsKey(ch)) {

                stack.push(ch);
            }

        }


        return stack.size();
    }
}
