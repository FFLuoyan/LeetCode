package org.zongjieli.leetcode.competion.singleweekly.order185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ShowOrder
 * @Description: 给定一个数组 orders,表示客户在餐厅中完成的订单
 *              有 order[i] = [customerName,tableNumber,foodItem]
 *              表示 客户姓名,餐桌桌号,餐品名称
 *              请返回该餐厅的点菜展示表
 *              该表第一行为标题,其第一列为餐桌桌号 Table,后面每一列都是按照字母顺序排列的餐品名称
 *              每一行的项则表示每张餐桌订购的相应餐品数量,第一列应当对应桌号,后面依次为下单的餐品数量
 * @Author: Zongjie.Li
 * @Date: 2020/4/19
 * @Version: 1.0
 **/
public class ShowOrder {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String,List<String>> deskMap = new HashMap<>();
        List<List<String>> displayTable = new ArrayList<>();
        List<String> foodList = new ArrayList<>();
        foodList.add("Table");
        displayTable.add(foodList);
        for (int orderIndex = 0; orderIndex< orders.size();orderIndex++){
            List<String> order = orders.get(orderIndex);
            String deskNumber = order.get(1);
            // 获取当前订单餐桌订单情况
            List<String> deskList = deskMap.get(deskNumber);
            if (deskList == null){
                // 如果当前餐桌不存在,则初始化
                deskList = new ArrayList<>();
                deskList.add(deskNumber);
                deskMap.put(deskNumber,deskList);
                for (int foodIndex = 1;foodIndex < foodList.size();foodIndex++){
                    deskList.add("0");
                }
            }
            // 获取当前订单食物情况
            String foodName = order.get(2);
            boolean foodExist = false;
            for (int foodIndex = 1;foodIndex < foodList.size();foodIndex++){
                if (foodList.get(foodIndex).equals(foodName)){
                    foodExist = true;
                    break;
                }
            }
            // 食物初始化
            if (!foodExist){
                int foodIndex = 1;
                for (;foodIndex < foodList.size();foodIndex++){
                    if (foodList.get(foodIndex).compareTo(foodName) > 0){
                        // 小于零则为字符串数值小于
                        foodList.add(foodIndex,foodName);
                        break;
                    }
                }
                if (foodIndex >= foodList.size()){
                    // 食物名字最大
                    foodList.add(foodName);
                }
                // 初始化场上所有订单
                for (Map.Entry<String,List<String>> desk: deskMap.entrySet()){
                        desk.getValue().add(foodIndex,"0");
                }
            }
            // 增加订单
            for (int foodIndex = 0;foodIndex<foodList.size();foodIndex++){
                if (foodList.get(foodIndex).equals(foodName)){
                    String deskOrderNumber = deskList.get(foodIndex);
                    deskOrderNumber = String.valueOf(Integer.valueOf(deskOrderNumber) + 1);
                    deskList.set(foodIndex,deskOrderNumber);
                }
            }
        }
        for (List<String> desk:deskMap.values()){
            displayTable.add(desk);
        }
        return displayTable;
    }
}
