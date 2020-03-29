package org.zongjieli.leetcode.competion.singleweekly.order182;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DesignMetro
 * @Description: 设计一个地铁系统类
 * 该类支持
 * checkIn(int id,String stationName,int t)
 * 编号为 id 的乘客在 t 时刻进入地铁站 stationName
 * 一个乘客在同一时间只能在一个地铁站进入或离开
 * checkOut(int id,String stationName,int t)
 * 编号为 id 的乘客在 t 时刻离开地铁站 stationName
 * getAverageTime(String startStation,String endStation)
 * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间
 * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的形成
 * 调用 getAverageTime 时,询问的路线至少包含一趟形成
 * 可以假设所有 checkIn 与 checkOut 的调用都是符合逻辑的,离开时间一定大于进入时间
 * @Author: Zongjie.Li
 * @Date: 2020/3/29
 * @Version: 1.0
 **/
public class DesignMetro {

    public Map<String, Map<String, int[]>> timeRecord = new HashMap<>();
    public Map<Integer, Map<String,Object>> customerRecord = new HashMap<>();

    public DesignMetro() {
    }

    public void checkIn(int id, String stationName, int t) {
        Map<String,Object> singleRecord = new HashMap<>(2);
        singleRecord.put("Station",stationName);
        singleRecord.put("Time",t);
        customerRecord.put(id, singleRecord);
    }

    public void checkOut(int id, String stationName, int t) {
        // 获取乘客进站记录
        Map<String,Object> singleRecord = this.customerRecord.get(id);
        // 获取始发站的所有终到站记录
        String startStationName = (String) singleRecord.get("Station");
        Map<String, int[]> stationTimeRecord = this.timeRecord.get(startStationName);
        if (stationTimeRecord == null) {
            // 如果当前出站乘客的始发站没有纪律,则为第一次添加,将始发站添加进记录表
            stationTimeRecord = new HashMap<>();
            this.timeRecord.put(startStationName, stationTimeRecord);
        }
        // 如果终到站没有纪律,则将终到站添加进记录表
        int[] stationRecord = stationTimeRecord.get(stationName);
        if (stationRecord == null) {
            stationRecord = new int[2];
            stationTimeRecord.put(stationName, stationRecord);
        }
        Integer checkInTime = (Integer) singleRecord.get("Time");
        stationRecord[0] += 1;
        stationRecord[1] += (t - checkInTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String, int[]> startStationRecord = this.timeRecord.get(startStation);
        int[] stationTimeRecord = startStationRecord.get(endStation);
        return Double.valueOf(stationTimeRecord[1]) / stationTimeRecord[0];
    }


    public static void main(String[] args) {
        DesignMetro designMetro = new DesignMetro();
        designMetro.checkIn(45, "Leyton", 3);
        designMetro.checkIn(32, "Paradise", 8);
        designMetro.checkIn(27, "Leyton", 10);
        designMetro.checkOut(45, "Waterloo", 15);
        designMetro.checkOut(27, "Waterloo", 20);
        designMetro.checkOut(32, "Cambridge", 22);
        designMetro.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        designMetro.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        designMetro.checkIn(10, "Leyton", 24);
        System.out.println(designMetro.getAverageTime("Leyton", "Waterloo"));          // 返回 11.0
        designMetro.checkOut(10, "Waterloo", 38);
        designMetro.getAverageTime("Leyton", "Waterloo");
    }
}
