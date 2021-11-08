package org.zongjieli.leetcode.question.daily.year2021.month11.week2;
/**
 * 和朋友一起玩猜数字(Bulls and Cows)游戏,该游戏规则如下:
 *
 *  写出一个秘密数字,并请朋友猜这个数字是多少,朋友每猜测一次,就会给他一个包含下述信息的提示:
 *   猜测数字中有多少位属于数字和确切位置都猜对了(称为 "Bulls", 公牛)
 *   有多少位属于数字猜对了但是位置不对(称为 "Cows", 奶牛),也就是说,这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字
 *
 * 给定一个秘密数字 secret 和朋友猜测的数字 guess,请返回对朋友这次猜测的提示
 *
 * 提示的格式为 "xAyB",x 是公牛个数,y 是奶牛个数,A 表示公牛,B 表示奶牛
 *
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字
 *
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret 和 guess 仅由数字组成
 *
 * @author   Li.zongjie
 * @date     2021/11/8
 * @version  1.0
 */
public class GuessNumberGame {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        for (int i = 0 ; i < secret.length() ; i++){
            count[secret.charAt(i) - '0']++;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0 ; i < guess.length() ; i++) {
            char guessChar = guess.charAt(i);
            char rightChar = secret.charAt(i);
            int index = guessChar - '0';
            if (guessChar == rightChar) {
                bull++;
                if (count[index] == 0) {
                    cow--;
                } else {
                    count[index]--;
                }
            } else if (count[index] > 0) {
                count[index]--;
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}
