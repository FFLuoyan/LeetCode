package org.zongjieli.leetcode.question.daily.year2022.month10.week1;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串(例如: "RXXLRXRXL")中进行移动操作
 * 一次移动操作指用一个 "LX" 替换一个 "XL",或者用一个 "XR" 替换一个 "RX"
 * 现给定起始字符串 start 和结束字符串 end
 * 当且仅当存在一系列移动操作使得 start 可以转换成 end 时,返回 True
 *
 * 1 <= len(start) = len(end) <= 10000
 * start 和 end 中的字符串仅限于'L', 'R'和'X'
 *
 * @author   Li.zongjie
 * @date     2022/10/21
 * @version  1.0
 */
public class Z7ExchangeLrx {

    public boolean canTransform(String start, String end) {
        int length = start.length();
        boolean result = true;
        for (int i = 0 ; i < length ; i++) {
            char sc = start.charAt(i);
            char ec = end.charAt(i);
            if (sc != ec) {
                result = false;
                if (sc == 'X') {
                    if (ec == 'R') {
                        return false;
                    }
                    // ec = L,start 后续必须为 XXXXLXLXL,同时对应 end 必须为 LXXLLXXX
                    int count = 1;
                    for (i++ ; i < length ; i++) {
                        ec = end.charAt(i);
                        if (ec == 'R') {
                            return false;
                        }
                        if (ec == 'L') {
                            count++;
                        }
                        sc = start.charAt(i);
                        if (sc == 'R') {
                            return false;
                        }
                        if (sc == 'L' && --count == 0) {
                            result = true;
                            break;
                        }
                    }
                } else if (sc == 'L') {
                    return false;
                } else {
                    // sc = R,start 后续必须为 RXRR,同时对应 end 必须为 XRRR
                    int count = 1;
                    for (i++ ; i < length ; i++) {
                        sc = start.charAt(i);
                        if (sc == 'L') {
                            return false;
                        }
                        if (sc == 'R') {
                            count++;
                        }
                        ec = end.charAt(i);
                        if (ec == 'L') {
                            return false;
                        }
                        if (ec == 'R' && --count == 0) {
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z7ExchangeLrx test = new Z7ExchangeLrx();
        // true
        System.out.println(test.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        // true
        System.out.println(test.canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
    }
}
