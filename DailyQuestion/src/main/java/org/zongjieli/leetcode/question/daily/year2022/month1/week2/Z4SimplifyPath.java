package org.zongjieli.leetcode.question.daily.year2022.month1.week2;
/**
 * 给定一个字符串 path
 * 表示指向某一文件或目录的 Unix 风格绝对路径(以 '/' 开头)
 * 请将其转化为更加简洁的规范路径
 * 在 Unix 风格的文件系统中
 * 一个点 (.) 表示当前目录本身
 * 此外,两个点 (..) 表示将目录切换到上一级(指向父目录)
 * 两者都可以是复杂相对路径的组成部分
 * 任意多个连续的斜杠(即,'//')都被视为单个斜杠 '/'
 * 对于此问题,任何其他格式的点(例如,'...')均被视为文件/目录名称
 * 请注意,返回的规范路径必须遵循下述格式:
 *  始终以斜杠 '/' 开头
 *  两个目录名之间必须只有一个斜杠 '/'
 *  最后一个目录名(如果存在)不能以 '/' 结尾
 *  此外,路径仅包含从根目录到目标文件或目录的路径上的目录(即,不含 '.' 或 '..')
 * 返回简化后得到的规范路径
 *
 * 1 <= path.length <= 3000
 * path 由英文字母,数字,'.','/' 或 '_' 组成
 * path 是一个有效的 Unix 风格绝对路径
 *
 * @author   Li.zongjie
 * @date     2022/1/6
 * @version  1.0
 */
public class Z4SimplifyPath {
    public String simplifyPath(String path) {
        path = path + "/";
        path = path.replaceAll("[/]+", "/").replaceAll("(/\\.)+/", "/");
        int length = path.length();
        while (length != (length = (path = path.replaceFirst("/[a-zA-Z0-9_.]+?/\\.\\./","/")).length())){ }
        path = path.replaceAll("(/\\.\\.)+/", "/");
        return path.length() != 1 ? path.substring(0, path.length() - 1) : path;
    }

    public static void main(String[] args) {
        Z4SimplifyPath test = new Z4SimplifyPath();
        // /home
        System.out.println(test.simplifyPath("/home/"));
        // /
        System.out.println(test.simplifyPath("/../"));
        // /c
        System.out.println(test.simplifyPath("/a/./b/../../c/"));
        // /c
        System.out.println(test.simplifyPath("/a/../../b/../c//.//"));
        // /a/b/c
        System.out.println(test.simplifyPath("/a//b////c/d//././/.."));
        // /e/f/g
        System.out.println(test.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
