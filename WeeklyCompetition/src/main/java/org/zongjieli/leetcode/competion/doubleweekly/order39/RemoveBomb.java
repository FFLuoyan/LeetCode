package org.zongjieli.leetcode.competion.doubleweekly.order39;

/**
 * @ClassName: RemoveBomb
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/11/14
 * @Version: 1.0
 **/
public class RemoveBomb {

    public int[] decrypt(int[] code, int k) {
        if (k == 0){
            for (int i = 0 ; i < code.length;i++){
                code[i] = 0;
            }
            return code;
        }
        int[] temp = new int[code.length];
        for (int i = 0 ; i< code.length ; i++){
            temp[i] = code[i];
        }

        if (k > 0){
            int first = 0;
            for (int i = 0 ; i < k ; i++){
                first += code[k+1];
            }
            code[0] = first;
            for (int i = 1 ; i < code.length ; i ++){
                int tempAddIndex = i + k;
                tempAddIndex = tempAddIndex < code.length ? tempAddIndex : tempAddIndex - code.length;
                code[i] = code[i-1] - temp[i - 1] + temp[tempAddIndex];
            }
        }



        return code;
    }

    public static void main(String[] args) {
        RemoveBomb removeBomb = new RemoveBomb();
        removeBomb.decrypt(new int[]{1,5,2,3,6,4},8);
    }


}
