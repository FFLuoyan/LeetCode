package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个 C++ 程序,删除程序中的注释
 * 这个程序 source 是一个数组,其中 source[i]表示第 i 行源码
 * 这表示每行源码由 '\n' 分隔
 * 在 C++ 中有两种注释风格,行内注释和块注释
 * 字符串 // 表示行注释,表示 // 和其右侧的其余字符应该被忽略
 * 字符串 /* 表示一个块注释,它表示直到下一个(非重叠)出现的 */ /** 之间的所有字符都应该被忽略
 * 非重叠是指,字符串/*/ /**并没有结束块注释,因为注释的结尾与开头相重叠
 * 第一个有效注释优先于其他注释
 * 如果字符串 // 出现在块注释中会被忽略
 * 同样,如果字符串 /* 出现在行或块注释中也会被忽略
 * 如果一行在删除注释之后变为空字符串,那么不要输出该行
 * 即,答案列表中的每个字符串都是非空的
 * 样例中没有控制字符,单引号或双引号字符
 * 此外,没有其他内容(如定义或宏)会干扰注释
 * 题目保证每一个块注释最终都会被闭合,所以在行或块注释之外的 /* 总是开始新的注释
 * 最后,隐式换行符可以通过块注释删除
 * 从源代码中删除注释后,需要以相同的格式返回源代码
 *
 * 1 <= source.length <= 100
 * 0 <= source[i].length <= 80
 * source[i] 由可打印的 ASCII 字符组成
 * 每个块注释都会被闭合
 * 给定的源码中不会有单引号、双引号或其他控制字符
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/3
 */
public class Z4DeleteComment {

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        int bi = -2;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            char[] lineChar = line.toCharArray();
            for (int i = 0; i < lineChar.length; i++) {
                char c = lineChar[i];
                if (bi == -2) {
                    if (c != '/' || i == lineChar.length - 1) {
                        sb.append(c);
                    } else if ((c = lineChar[++i]) == '*') {
                        bi = i;
                    } else if (c == '/') {
                        break;
                    } else {
                        sb.append('/');
                        sb.append(c);
                    }
                } else if (c == '/' && i - 1 > bi && lineChar[i - 1] == '*') {
                    bi = -2;
                }
            }
            if (bi > -2) {
                bi = -1;
            } else if (sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4DeleteComment test = new Z4DeleteComment();
        //
        System.out.println(test.removeComments(new String[]{"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"}));
    }
}
