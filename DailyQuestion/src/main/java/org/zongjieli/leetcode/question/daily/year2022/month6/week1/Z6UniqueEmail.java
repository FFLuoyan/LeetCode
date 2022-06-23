package org.zongjieli.leetcode.question.daily.year2022.month6.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * 每个有效电子邮件地址都由一个本地名和一个域名组成,以 '@' 符号分隔
 * 除小写字母之外,电子邮件地址还可以含有一个或多个 '.' 或 '+'
 *  例如,在 alice@leetcode.com中,alice 是本地名,而 leetcode.com 是域名
 * 如果在电子邮件地址的本地名部分中的某些字符之间添加句点('.')
 * 则发往那里的邮件将会转发到本地名中没有点的同一地址,请注意此规则不适用于域名
 *  例如,"alice.z@leetcode.com" 和 "alicez@leetcode.com" 会转发到同一电子邮件地址
 * 如果在本地名中添加加号 ('+') 则会忽略第一个加号后面的所有内容
 * 这允许过滤某些电子邮件,同样,此规则不适用于域名
 *  例如 m.y+name@email.com 将转发到 my@email.com
 * 可以同时使用这两个规则
 *
 * 给定一个字符串数组 emails,会向每个 emails[i] 发送一封电子邮件
 * 返回实际收到邮件的不同地址数目
 *
 * 1 <= emails.length <= 100
 * 1 <= emails[i].length <= 100
 * emails[i] 由小写英文字母、'+'、'.' 和 '@' 组成
 * 每个 emails[i] 都包含有且仅有一个 '@' 字符
 * 所有本地名和域名都不为空
 * 本地名不会以 '+' 字符作为开头
 *
 * @author   Li.zongjie
 * @date     2022/6/23
 * @version  1.0
 */
public class Z6UniqueEmail {

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] es = email.split("@");
            emailSet.add(es[0].split("\\+")[0].replaceAll("\\.", "") + "@" + es[1]);
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        Z6UniqueEmail test = new Z6UniqueEmail();
        // 2
        System.out.println(test.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
