package org.zongjieli.leetcode.question.daily.year2022.month5.week5;
/**
 * 给定一个字符串 queryIP
 * 如果是有效的 IPv4 地址,返回 "IPv4"
 * 如果是有效的 IPv6 地址,返回 "IPv6"
 * 如果不是上述类型的 IP 地址,返回 "Neither"
 *
 * 有效的 IPv4 地址是 "x1.x2.x3.x4" 形式的IP地址
 * 其中 0 <= xi <= 255 且 xi 不能包含前导零
 * 例如:
 *  "192.168.1.1"、"192.168.1.0" 为有效IPv4地址
 *  "192.168.01.1"、"192.168.1.00"、"192.168@1.1" 为无效 IPv4 地址
 *
 * 一个有效的 IPv6 地址是一个格式为 "x1:x2:x3:x4:x5:x6:x7:x8" 的 IP 地址
 * 其中:
 *  1 <= xi.length <= 4
 *  xi 是一个十六进制字符串,可以包含数字、小写英文字母('a' 到 'f')和大写英文字母('A' 到 'F')
 *  在 xi 中允许前导零。
 * 例如:
 *  "2001:0db8:85a3:0000:0000:8a2e:0370:7334"、"2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址
 *  "2001:0db8:85a3::8A2E:037j:7334"、"02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址
 *
 * queryIP 仅由英文字母、数字、字符 '.' 和 ':' 组成
 *
 * @author   Li.zongjie
 * @date     2022/5/30
 * @version  1.0
 */
public class Z7ValidateIP {

    public String validIPAddress(String queryIP) {
        return queryIP.contains(".") ? queryIP.matches("(((0)|(1[0-9]{0,2})|(2(([6-9])|([0-4][0-9]?)|(5[0-5])))|([3-9][0-9]?))\\.){3}((0)|(1[0-9]{0,2})|(2(([6-9])|([0-4][0-9]?)|(5[0-5])))|([3-9][0-9]?))") ? "IPv4" : "Neither" : queryIP.matches("([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}") ? "IPv6" : "Neither";
    }

    public static void main(String[] args) {
        Z7ValidateIP test = new Z7ValidateIP();
        // Ipv4
        System.out.println(test.validIPAddress("172.16.254.1"));
        // Neither
        System.out.println(test.validIPAddress("256.256.256.256"));
        // Ipv4
        System.out.println(test.validIPAddress("192.0.0.1"));
    }

}
