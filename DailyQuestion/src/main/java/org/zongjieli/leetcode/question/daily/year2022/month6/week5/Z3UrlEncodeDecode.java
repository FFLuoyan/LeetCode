package org.zongjieli.leetcode.question.daily.year2022.month6.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TinyURL 是一种 URL 简化服务
 * 比如:
 *  当输入一个 URL: https://leetcode.com/problems/design-tinyurl 时
 *  它将返回一个简化的 URL: http://tinyurl.com/4e9iAk
 *  请设计一个类来加密与解密 TinyURL
 *
 * 加密和解密算法如何设计和运作是没有限制的
 * 只需要保证一个 URL 可以被加密成一个 TinyURL
 * 并且这个 TinyURL 可以用解密方法恢复成原本的 URL
 *
 * 实现 Z3UrlEncodeDecode 类：
 *  Z3UrlEncodeDecode()
 *      初始化 TinyURL 系统对象
 *  String encode(String longUrl)
 *      返回 longUrl 对应的 TinyURL
 *  String decode(String shortUrl)
 *      返回 shortUrl 原本的 URL
 *
 * 题目数据保证给定的 shortUrl 是由同一个系统对象加密的
 *
 * 1 <= url.length <= 10^4
 * 题目数据保证 url 是一个有效的 URL
 *
 * @author   Li.zongjie
 * @date     2022/6/29
 * @version  1.0
 */
public class Z3UrlEncodeDecode {

    private int count = 0;
    private List<String> save = new ArrayList<>();

    public String encode(String longUrl) {
        save.add(longUrl);
        return "" + count++;
    }

    public String decode(String shortUrl) {
        return save.get(Integer.parseInt(shortUrl));
    }
}
