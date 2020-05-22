package org.zongjieli.leetcode.algorthm.intermediate.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: BracketGenerator
 * @Description: 给定需要生成括号的对数,生成所有可能的并且有效的括号组合
 * @Author: Zongjie.Li
 * @Date: 2020/5/22
 * @Version: 1.0
 **/
public class BracketGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> bracketList = new LinkedList<>();
        if (n == 0){
            return bracketList;
        }
        char[] bracketValue = new char[2*n];
        bracketConstruct(bracketValue,bracketList,0,0);
        return bracketList;
    }

    public void bracketConstruct(char[] bracketValue,List<String> bracketList,int index,int leftCount){
        if (leftCount == 0){
            // 如果左括号数量为 0,则必须为 左括号
            bracketValue[index] = '(';
            bracketConstruct(bracketValue,bracketList,index + 1,1);
        }else if (index + leftCount == bracketValue.length){
            // 剩余数量均为右括号
            for (int i = index ; i < bracketValue.length ; i++){
                bracketValue[i] = ')';
            }
            bracketList.add(String.valueOf(bracketValue));
        } else {
            // 左右括号随机切换
            bracketValue[index] = '(';
            bracketConstruct(bracketValue,bracketList,index + 1,leftCount + 1);
            bracketValue[index] = ')';
            bracketConstruct(bracketValue,bracketList,index + 1,leftCount - 1);
        }
    }

    public static void main(String[] args) {
        BracketGenerator bracketGenerator = new BracketGenerator();
        System.out.println(bracketGenerator.generateParenthesis(1));
    }
}
