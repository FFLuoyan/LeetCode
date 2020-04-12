package org.zongjieli.leetcode.competion.singleweekly.order184;

/**
 * @ClassName: HtmlTransfer
 * @Description: 对 HTML 内容进行解析,用字符替换特殊的字符实体
 *               双引号：字符实体为 &quot; ，对应的字符是 " 。
 *               单引号：字符实体为 &apos; ，对应的字符是 ' 。
 *               与符号：字符实体为 &amp; ，对应对的字符是 & 。
 *               大于号：字符实体为 &gt; ，对应的字符是 > 。
 *               小于号：字符实体为 &lt; ，对应的字符是 < 。
 *               斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * @Author: Zongjie.Li
 * @Date: 2020/4/12
 * @Version: 1.0
 **/
public class HtmlTransfer {
    public String entityParser(String text) {
        return text.replace("&quot;","\"")
                .replace("&apos;","\'")
                .replace("&gt;",">")
                .replace("&lt;","<")
                .replace("&frasl;","/")
                .replace("&amp;","&");
    }
}
