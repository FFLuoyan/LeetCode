package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

import java.util.*;

/**
 * 一位系统管理员,手里有一份文件夹列表 folder,任务是要删除该列表中的所有子文件夹,并以任意顺序返回剩下的文件夹
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下,那么 folder[i] 就是 folder[j] 的子文件夹
 * 文件夹的 "路径" 是由一个或多个按以下格式串联形成的字符串: '/' 后跟一个或者多个小写英文字母
 * 例如, "/leetcode" 和 "/leetcode/problems" 都是有效的路径,而空字符串和 "/" 不是
 *
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * 每个文件夹名都是唯一的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/8
 */
public class Z3RemoveFolder {

    public List<String> removeSubfolders(String[] folder) {
        Tree base = new Tree();
        byte[][] folderBytes = new byte[folder.length][];
        for (int i = 0; i < folderBytes.length; i++) {
            folderBytes[i] = folder[i].getBytes();
            if (!existAndAdd(base, folderBytes[i])) {
                folderBytes[i][0] = 0;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (folderBytes[i][0] != 0 && existAndAdd(base, folderBytes[i])) {
                result.add(folder[i]);
            }
        }
        return result;
    }

    public boolean existAndAdd(Tree current, byte[] values) {
        for (byte b : values) {
            if (b == '/') {
                if (current.isExist) {
                    return false;
                }
                b = 26;
            } else {
                b -= 'a';
            }
            if (current.next[b] == null) {
                current.next[b] = new Tree();
            }
            current = current.next[b];
        }
        current.isExist = true;
        return true;
    }

    class Tree {
        boolean isExist = false;
        Tree[] next = new Tree[27];
    }

    public static void main(String[] args) {
        Z3RemoveFolder test = new Z3RemoveFolder();
        // /a, /c/d, /c/f"
        System.out.println(test.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
    }

}
