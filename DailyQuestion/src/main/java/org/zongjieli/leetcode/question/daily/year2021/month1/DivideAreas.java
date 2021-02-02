package org.zongjieli.leetcode.question.daily.year2021.month1;

/**
 * 在由 1×1 方格组成的 N×N 网格 grid 中
 * 每个 1×1 方格由 "/"、"\" 或空格 " " 构成
 * 这些字符会将方块划分为一些共边的区域
 * 请返回区域的数目
 *
 * Attention: "\" 是转义的,由 "\\" 表示
 *
 * @author   Zongjie.Li
 * @date     2021/1/25
 * @version  1.0
 */
public class DivideAreas {

    int count = 0;

    public int regionsBySlashes(String[] grid) {
        // 将区域划分成为一个个的节点
        int[] areas = new int[4 * grid.length * grid.length];
        // 未遍历时,区域数为节点总数
        count = areas.length;
        for (int i = 0 ; i < areas.length ; i++){
            areas[i] = i;
        }

        for (int lineIndex = 0 ; lineIndex < grid.length ; lineIndex++){
            String line = grid[lineIndex];
            for (int areaIndex = 0 ; areaIndex < grid.length ; areaIndex++){
                char gridValue = line.charAt(areaIndex);
                int index = 4 * lineIndex * grid.length + 4 * areaIndex;
                if (gridValue == '/'){
                    mix(areas,index,index + 3);
                    mix(areas,index + 1,index + 2);
                } else if (gridValue == ' '){
                    mix(areas,index,index + 1);
                    mix(areas,index,index + 2);
                    mix(areas,index,index + 3);
                } else {
                    // \
                    mix(areas,index,index + 1);
                    mix(areas,index + 2,index + 3);
                }
                if (lineIndex != grid.length - 1){
                    // 合并下一行
                    mix(areas,index + 2,index + 4 * grid.length);
                }

                if (areaIndex != grid.length - 1){
                    // 合并右边
                    mix(areas,index + 1,index + 7);
                }

            }
        }
        return count;
    }

    public void mix(int[] areas,int first,int second){
        int rootFirst = areas[first];
        while (rootFirst != areas[rootFirst]){
            rootFirst = areas[rootFirst];
        }

        int rootSecond = areas[second];
        while (rootSecond != areas[rootSecond]){
            rootSecond = areas[rootSecond];
        }

        if (rootSecond != rootFirst){
            areas[rootSecond] = rootFirst;
            count --;
        }

    }


    public static void main(String[] args) {
        DivideAreas divideAreas = new DivideAreas();
        System.out.println(divideAreas.regionsBySlashes(new String[]{"\\/\\//","/ / \\","\\ \\/\\","\\  /\\","\\/ / "}));
    }
}
