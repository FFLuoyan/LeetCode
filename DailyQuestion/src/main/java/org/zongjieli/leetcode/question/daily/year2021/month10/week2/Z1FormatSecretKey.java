package org.zongjieli.leetcode.question.daily.year2021.month10.week2;
/**
 * 有一个密钥字符串 S 只包含字母,数字以及 '-' (破折号)
 * 其中,N 个 '-' 将字符串分成了 N+1 组
 *
 * 给定一个数字 K,重新格式化字符串,使每个分组恰好包含 K 个字符
 * 特别地,第一个分组包含的字符个数必须小于等于 K,但至少要包含 1 个字符
 * 两个分组之间需要用 '-'(破折号)隔开,并且将所有的小写字母转换为大写字母
 *
 * 给定非空字符串 S 和数字 K,按照上面描述的规则进行格式化
 *
 * S 的长度可能很长,请按需分配大小,K 为正整数
 * S 只包含字母数字(a-z,A-Z,0-9)以及破折号'-'
 * S 非空
 *
 * @author   Li.zongjie
 * @date     2021/10/20
 * @version  1.0
 */
public class Z1FormatSecretKey {
    public String licenseKeyFormatting(String s, int k) {
        char[] save = new char[2 * s.length()];
        int sIndex = s.length();
        int saveIndex = save.length;
        int count = 0;
        while (--sIndex >= 0){
            char currentChar = s.charAt(sIndex);
            if (currentChar == '-'){
                continue;
            }
            if (currentChar >= 'a' && currentChar <= 'z'){
                currentChar += ('A' - 'a');
            }
            save[--saveIndex] = currentChar;
            count++;
            if (count == k){
                save[--saveIndex] = '-';
                count = 0;
            }
        }
        if (saveIndex == save.length){
            return "";
        }
        if (save[saveIndex] == '-'){
            saveIndex++;
        }
        return new String(save,saveIndex,save.length - saveIndex);
    }

    public static void main(String[] args) {
        Z1FormatSecretKey test = new Z1FormatSecretKey();
//        System.out.println(test.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(test.licenseKeyFormatting("---", 4));
    }
}
