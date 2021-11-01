package org.zongjieli.leetcode.question.daily.year2021.month10.week5;

import java.util.Arrays;

/**
 * 给定一个字符串数组 words
 * 只返回可以使用在美式键盘同一行的字母打印出来的单词
 *
 * 美式键盘 中:
 *  第一行由字符 "qwertyuiop" 组成
 *  第二行由字符 "asdfghjkl" 组成
 *  第三行由字符 "zxcvbnm" 组成
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母(小写和大写字母)组成
 *
 * @author   Li.zongjie
 * @date     2021/11/1
 * @version  1.0
 */
public class Z7KeyBoardLine {

    public String[] findWords(String[] words) {
        int[] belong = new int[]{2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};

        String[] record = new String[20];
        int index = 0;
        for (String word : words) {
            int first = word.charAt(0);
            if (first <= 90){
                first += 32;
            }
            first -= 97;
            int row = belong[first];
            int i = 1;
            for (; i < word.length() ; i++){
                int current = word.charAt(i);
                if (current <= 90){
                    current += 32;
                }
                current -= 97;
                if (belong[current] != row){
                    break;
                }
            }
            if (i == word.length()){
                record[index++] = word;
            }
        }

        return Arrays.copyOf(record, index);

    }

    public static void main(String[] args) {
        Z7KeyBoardLine test = new Z7KeyBoardLine();
        System.out.println(Arrays.toString(test.findWords("asdasdasd,asdadasasdfas,qwrqwferwq,cxvzx,cvzxvxz,cva,sf,qw, gfe,rg,fqcw,qer ,wef,wc,fwq".replaceAll(" ","").split(","))));
    }
}
