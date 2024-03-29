package org.zongjieli.leetcode.question.daily.year2021.month10.week1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一份旅游线路图,该线路图中的旅行线路用数组 paths 表示
 * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi
 * 请找出这次旅行的终点站,即没有任何可以通往其他城市的线路的城市
 * 题目数据保证线路图会形成一条不存在循环的线路,因此恰有一个旅行终点站
 *
 *  1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成
 *
 * @author   Li.zongjie
 * @date     2021/10/21
 * @version  1.0
 */
public class Z5EndCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>(256);
        paths.forEach(path -> pathMap.put(path.get(0), path.get(1)));
        String result = paths.get(0).get(1);
        while (pathMap.containsKey(result)){
            result = pathMap.get(result);
        }
        return result;
    }
}
