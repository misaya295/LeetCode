package leetcode.力扣题.题93;


import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        StringBuffer ip = new StringBuffer();

        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {

                        if (a + b + c + d == s.length()) {
                            int seg1 = Integer.parseInt(s.substring(0, a));
                            int seg2 = Integer.parseInt(s.substring(a, a+b));
                            int seg3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int seg4 = Integer.parseInt(s.substring(a+b+c, a+b+c+d));
                            if (seg1 <= 255 && seg2 <= 255 && seg3 <= 255 && seg4 <= 255) {
                                ip.append(seg1).append(".")
                                   .append(seg2).append(".")
                                   .append(seg3).append(".")
                                   .append(seg4);
                                if (ip.length() == s.length() + 3) {
                                    result.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
