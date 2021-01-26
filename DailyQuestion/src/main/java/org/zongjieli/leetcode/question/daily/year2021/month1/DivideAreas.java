package org.zongjieli.leetcode.question.daily.year2021.month1;

import java.util.*;

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

    public int regionsBySlashes(String[] grid) {
        int number = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Set<Integer>> list = new ArrayList<>();
        int[][] areas = new int[grid.length][grid.length * 4];
        for (int lineIndex = 0;lineIndex < grid.length ; lineIndex ++){
            for (int areaIndex = 0 ; areaIndex < grid.length;areaIndex++){
                char gridChar = grid[lineIndex].charAt(areaIndex);
                if (gridChar == '/'){
                    if (lineIndex == 0){
                        if (areaIndex == 0){
                            // 左上角
                            createNewSet(0,map,list);
                            areas[0][0] = number;
                            areas[0][3] = number;
                            createNewSet(++number,map,list);
                            areas[0][1] = number;
                            areas[0][2] = number;
                        } else {
                            // 第一行非首位
                            extendValue(true,0,areaIndex,areas,0,3);
                            createNewSet(++number,map,list);
                            areas[0][4 * areaIndex + 1] = number;
                            areas[0][4 * areaIndex + 2] = number;
                        }
                    } else {
                        if (areaIndex == 0){
                            // 非首行首位
                            extendValue(false,lineIndex,0,areas,0,3);
                            createNewSet(++number,map,list);
                            areas[lineIndex][1] = number;
                            areas[lineIndex][2] = number;
                        } else {
                            // 非首行、非首位
                            extendValue(true,lineIndex,areaIndex,areas,0,3);
                            checkValue(lineIndex,areaIndex,map,list,areas);
                            createNewSet(++number,map,list);
                            areas[lineIndex][4 * areaIndex + 1] = number;
                            areas[lineIndex][4 * areaIndex + 2] = number;
                        }
                    }
                } else if (gridChar == ' '){
                    if (lineIndex == 0){
                        if (areaIndex == 0){
                            // 首行首位
                            areas[0][0] = 0;
                            areas[0][1] = 0;
                            areas[0][2] = 0;
                            areas[0][3] = 0;
                            createNewSet(0,map,list);
                        } else {
                            // 首行非首位
                            extendValue(true,0,areaIndex,areas,0,1,2,3);
                        }
                    } else {
                        if (areaIndex == 0){
                            // 非首行首位
                            extendValue(false,lineIndex,0,areas,0,1,2,3);
                        } else {
                            // 非首行、非首位
                            extendValue(false,lineIndex,areaIndex,areas,0,1,2,3);
                            checkValue(lineIndex,areaIndex,map,list,areas);
                        }
                    }
                } else {
                    // '\'
                    if (lineIndex == 0){
                        if (areaIndex == 0){
                            // 首行首位
                            createNewSet(0,map,list);
                            areas[0][0] = number;
                            areas[0][1] = number;
                            createNewSet(++number,map,list);
                            areas[0][2] = number;
                            areas[0][3] = number;
                        }else {
                            // 首行非首位
                            extendValue(true,0,areaIndex,areas,2,3);
                            createNewSet(++number,map,list);
                            areas[0][4 * areaIndex] = number;
                            areas[0][4 * areaIndex + 1] = number;
                        }
                    } else {
                        if (areaIndex == 0){
                            // 非首行首位
                            extendValue(false,lineIndex,0,areas,0,1);
                            createNewSet(++number,map,list);
                            areas[lineIndex][2] = number;
                            areas[lineIndex][3] = number;
                        } else {
                            // 非首行非首位
                            extendValue(false,lineIndex,areaIndex,areas,0,1);
                            extendValue(true,lineIndex,areaIndex,areas,2,3);
                        }
                    }
                }
            }
        }
        return list.size();
    }

    public void extendValue(boolean left,int lineIndex,int areaIndex,int[][] areas,int... indexes){
        for (int index : indexes){
            areas[lineIndex][4 * areaIndex + index] = areas[lineIndex + (left ? 0 : -1)][4 * areaIndex + (left ? -3 : 2)];
        }
    }

    public void createNewSet(int number,Map<Integer, Set<Integer>> map,List<Set<Integer>> list){
        Set<Integer> set = new HashSet<>();
        set.add(number);
        map.put(number,set);
        list.add(set);
    }

    public void checkValue(int lineIndex,int areaIndex,Map<Integer,Set<Integer>> map,List<Set<Integer>> list,int[][] areas){
        int leftValue = areas[lineIndex][4 * areaIndex - 3];
        int upValue = areas[lineIndex - 1][4 * areaIndex + 2];
        if (leftValue != upValue){
            Set<Integer> leftSet = map.get(leftValue);
            Set<Integer> upSet = map.get(upValue);
            if (leftSet != upSet){
                upSet.addAll(leftSet);
                upSet.forEach(value -> map.put(value,upSet));
                int removeIndex = 0;
                for (int setIndex = 0 ; setIndex < list.size() ; setIndex ++){
                    if (list.get(setIndex) == leftSet){
                        removeIndex = setIndex;
                        break;
                    }
                }
                list.remove(removeIndex);
            }
        }
    }

    public static void main(String[] args) {
        DivideAreas divideAreas = new DivideAreas();
        System.out.println(divideAreas.regionsBySlashes(new String[]{"\\/\\//","/ / \\","\\ \\/\\","\\  /\\","\\/ / "}));
    }
}
