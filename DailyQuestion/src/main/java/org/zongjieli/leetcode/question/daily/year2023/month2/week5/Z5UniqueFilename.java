package org.zongjieli.leetcode.question.daily.year2023.month2.week5;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个长度为 n 的字符串数组 names,在文件系统中创建 n 个文件夹:
 *  在第 i 分钟,新建名为 names[i] 的文件夹
 * 由于两个文件不能共享相同的文件名
 * 因此如果新建文件夹使用的文件名已经被占用
 * 系统会以 (k) 的形式为新文件夹的文件名添加后缀
 * 其中 k 是能保证文件名唯一的最小正整数
 *
 * 返回长度为 n 的字符串数组
 * 其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称
 *
 * 1 <= names.length <= 5 * 10^4
 * 1 <= names[i].length <= 20
 * names[i] 由小写英文字母、数字和 / 或圆括号组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/3
 */
public class Z5UniqueFilename {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Integer number = count.get(name);
            if (number == null) {
                count.put(name, 0);
            } else {
                String nextName;
                while (count.containsKey(nextName = name + '(' + ++number + ')')) {}
                count.put(nextName, 0);
                count.put(name, number);
                names[i] = nextName;
            }
        }
        return names;
    }

}
