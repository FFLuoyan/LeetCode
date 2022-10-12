package org.zongjieli.leetcode.question.daily.year2022.month10.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成
 * 顶级域名为 "com",二级域名为 "leetcode.com"
 * 最低一级为 "discuss.leetcode.com"
 * 当访问域名 "discuss.leetcode.com" 时
 * 同时也会隐式访问其父域名 "leetcode.com" 以及 "com"
 *
 * 计数配对域名是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示
 * 其中 rep 表示访问域名的次数,d1.d2.d3 为域名本身
 *
 * 例如 "9001 discuss.leetcode.com" 就是一个计数配对域名
 * 表示 discuss.leetcode.com 被访问了 9001 次
 *
 * 给定一个计数配对域名组成的数组 cpdomains
 * 解析得到输入中每个子域名对应的计数配对域名,并以数组形式返回
 * 可以按任意顺序返回答案
 *
 * 1 <= cpdomain.length <= 100
 * 1 <= cpdomain[i].length <= 100
 * cpdomain[i] 会遵循 "repi d1i.d2i.d3i" 或 "repi d1i.d2i" 格式
 * repi 是范围 [1, 10^4] 内的一个整数
 * d1i、d2i 和 d3i 由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z3DomainCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] countAndDomain = cpdomain.split(" ");
            int count = Integer.parseInt(countAndDomain[0]);
            String domain = countAndDomain[1];
            String[] domains = domain.split("\\.");
            countMap.merge(domain, count, Integer::sum);
            countMap.merge(domains[domains.length - 1], count, Integer::sum);
            if (domains.length == 3) {
                countMap.merge(domains[1] + "." + domains[2], count, Integer::sum);
            }
        }
        List<String> result = new ArrayList<>(2 * countMap.size());
        countMap.forEach((k, v) -> result.add(v + " " + k));
        return result;
    }
}
