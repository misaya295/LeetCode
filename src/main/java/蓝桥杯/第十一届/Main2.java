package 蓝桥杯.第十一届;


import com.sun.javafx.tools.packager.PackagerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*
2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
中国共产党成立于 1921 年 7 月 23 日。
请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包
含多少分钟？
【答案提交】
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。


52038720
 */
public class Main2 {


    public static void main(String[] args) throws  ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date start = sdf.parse("1921-7-23 12:00:00");
        Date end = sdf.parse("2020-7-1 12:00:00");
        long ans = end.getTime() - start.getTime();
        System.out.println(ans/60000);


    }


}
