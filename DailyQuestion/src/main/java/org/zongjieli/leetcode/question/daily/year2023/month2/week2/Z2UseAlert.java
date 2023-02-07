package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

import java.util.*;

/**
 * 力扣公司的员工都使用员工卡来开办公室的门
 * 每当一个员工使用一次他的员工卡,安保系统会记录下员工的名字和使用时间
 * 如果一个员工在一小时时间内使用员工卡的次数大于等于三次,这个系统会自动发布一个警告
 * 给定字符串数组 keyName 和 keyTime
 * 其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在某一天内使用员工卡的时间
 * 使用时间的格式是 24小时制,形如 "HH:MM",比方说 "23:51" 和 "09:49"
 * 请返回去重后的收到系统警告的员工名字,将它们按字典序升序排序后返回
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内
 * 而 "23:51" - "00:10" 不被视为一小时内,因为系统记录的是某一天内的使用情况
 *
 * 1 <= keyName.length, keyTime.length <= 10^5
 * keyName.length == keyTime.length
 * keyTime 格式为 "HH:MM"
 * 保证 [keyName[i], keyTime[i]] 形成的二元对互不相同
 * 1 <= keyName[i].length <= 10
 * keyName[i] 只包含小写英文字母
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/7
 */
public class Z2UseAlert {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> personTime = new HashMap<>();
        for (int i = 0; i < keyTime.length; i++) {
            String time = keyTime[i];
            int timeInt = 1000 * time.charAt(0) + 100 * time.charAt(1) + 10 * time.charAt(3) + time.charAt(4) - 1111 * '0';
            personTime.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(timeInt);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : personTime.entrySet()) {
            List<Integer> times = entry.getValue();
            times.sort(Integer::compareTo);
            for (int i = 2 ; i < times.size() ; i++) {
                if (times.get(i) - times.get(i - 2) <= 100) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        result.sort(String::compareTo);
        return result;
    }

    public static void main(String[] args) {
        Z2UseAlert test = new Z2UseAlert();
        System.out.println(test.alertNames(new String[]{"john", "john", "john"}, new String[]{"23:58", "23:59", "00:01"}));
    }

}
