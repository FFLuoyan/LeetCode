package org.zongjieli.leetcode.question.daily.year2023.month2.week1;

/**
 * 给定字符串 key 和 message,分别表示一个加密密钥和一段加密消息
 * 解密 message 的步骤如下:
 *  使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母顺序
 *  将替换表与普通英文字母表对齐,形成对照表
 *  按照对照表替换 message 中的每个字母
 *  空格 ' ' 保持不变
 * 例如,key = "happy boy"(实际的加密密钥会包含字母表中每个字母至少一次)
 * 据此,可以得到部分对照表('h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f')
 * 返回解密后的消息
 *
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符('a' 到 'z')至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/1
 */
public class Z3DecodeMessage {

    public String decodeMessage(String key, String message) {
        byte[] table = new byte[128], kvs = key.getBytes(), result = message.getBytes();
        table[' '] = ' ';
        byte add = 'a';
        for (int i = 0; i < kvs.length && add <= 'z'; i++) {
            if (table[kvs[i]] == 0) {
                table[kvs[i]] = add++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = table[result[i]];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Z3DecodeMessage test = new Z3DecodeMessage();
        // this is a secret
        System.out.println(test.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

}
