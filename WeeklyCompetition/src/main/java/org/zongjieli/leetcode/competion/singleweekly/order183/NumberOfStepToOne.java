package org.zongjieli.leetcode.competion.singleweekly.order183;

/**
 * @ClassName: NumberOfStepToOne
 * @Description: 给定一个以二进制表示的数字s
 *               如果为偶数,则除以 2
 *               如果为奇数,则加上 1
 *               计算将该数计算到 1 时的步骤数
 * @Author: Zongjie.Li
 * @Date: 2020/4/5
 * @Version: 1.0
 **/
public class NumberOfStepToOne {
    public int numSteps(String s) {
        int count = 0;
        boolean doubleCount = false;
        for (int i = s.length() - 1;i > 0; i--){
            if (s.charAt(i) == '0'){
                if (doubleCount){
                    count+=2;
                }else {
                    count ++;
                }
            } else {
                if (!doubleCount){
                    doubleCount = true;
                    count +=2;
                }

                for (int j = i;j > 0;j--){
                    count++;
                    if (s.charAt(j) == '1'){
                        i--;
                    } else {
                        count++;
                        break;
                    }
                }
            }
        }return count;
    }

    public static void main(String[] args) {
        NumberOfStepToOne numberOfStepToOne = new NumberOfStepToOne();
        String s = "110100011";//1110 111 1000

        System.out.println(numberOfStepToOne.numSteps(s));
    }
}
