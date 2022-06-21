package org.zongjieli.leetcode.question.daily.year2022.month6.week4;
/**
 * 给定一个有效的 IPv4 地址 address
 * 返回这个 IP 地址的无效化版本
 * 所谓无效化 IP 地址,其实就是用 "[.]" 代替了每个 "."
 * 给出的 address 是一个有效的 IPv4 地址
 *
 * @author   Li.zongjie
 * @date     2022/6/21
 * @version  1.0
 */
public class Z2IpUseless {

    public String defangIPaddr(String address) {
        char[] replace = new char[address.length() + 6];
        int index = 0;
        for (int i = 0 ; i < address.length() ; i++) {
            char cc = address.charAt(i);
            if (cc == '.') {
                replace[index++] = '[';
                replace[index++] = '.';
                replace[index++] = ']';
            } else {
                replace[index++] = cc;
            }
        }
        return new String(replace);
    }
}
