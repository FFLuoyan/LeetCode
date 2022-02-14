package org.zongjieli.leetcode.question.daily.year2022.month2.week2;

/**
 * 如果字符串中不含有任何 'aaa','bbb' 或 'ccc' 这样的字符串作为子串
 * 那么该字符串就是一个快乐字符串
 *
 * 给定三个整数 a,b,c,请返回任意一个满足下列全部条件的字符串 s:
 *  s 是一个尽可能长的快乐字符串
 *  s 中最多有 a 个字母 'a'、b 个字母 'b'、c 个字母 'c'
 *  s 中只含有 'a'、'b' 、'c' 三种字母
 *
 * 如果不存在这样的字符串 s,请返回一个空字符串 ""
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 * @author   Li.zongjie
 * @date     2022/2/7
 * @version  1.0
 */
public class Z1LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder(a + b + c);
        char ac = 'a', bc = 'b', cc = 'c', tempC;
        int temp;
        if (a < b){
            temp = a;
            a = b;
            b = temp;
            tempC = ac;
            ac = bc;
            bc = tempC;
        }

        if (c > a){
            temp = c;
            c = b;
            b = a;
            a = temp;
            tempC = cc;
            cc = bc;
            bc = ac;
            ac = tempC;
        } else if (c > b){
            temp = b;
            b = c;
            c = temp;
            tempC = cc;
            cc = bc;
            bc = tempC;
        }

        if (a >= 2 * (b + c)){
            while (b-- > 0){
                result.append(ac).append(ac).append(bc);
                a -= 2;
            }
            while (c-- > 0){
                result.append(ac).append(ac).append(cc);
                a -= 2;
            }
            if (a-- > 0){
                result.append(ac);
            }

            if (a > 0){
                result.append(ac);
            }
            return result.toString();
        }

        if (a >= b + c){
            while (a > b + c){
                if (b > 0) {
                    a -= 2;
                    b--;
                    result.append(ac).append(ac).append(bc);
                } else if (c > 0){
                    a -= 2;
                    c--;
                    result.append(ac).append(ac).append(cc);
                }
            }

            while (b-- > 0){
                result.append(ac).append(bc);
            }

            while (c-- > 0){
                result.append(ac).append(cc);
            }
            return result.toString();
        }

        while (a < b + c){
            result.append(ac).append(bc).append(cc);
            a--;
            b--;
            c--;
        }

        while (b-- > 0){
            result.append(ac).append(bc);
        }

        while (c-- > 0){
            result.append(ac).append(cc);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Z1LongestHappyString test = new Z1LongestHappyString();
        // ccaccbcc
        System.out.println(test.longestDiverseString(1,1,7));
        // ccacc
        System.out.println(test.longestDiverseString(1,0,3));
    }
}
