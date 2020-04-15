package org.zongjieli.leetcode.algorthm.intermediate.arrayandstring;

import java.util.*;

/**
 * @ClassName: DifferPositionWords
 * @Description: 给定一个字符串数据,将字母异味词组合在一起,字母异味词指字母相同,但排列不同的字符串
 * @Author: Zongjie.Li
 * @Date: 2020/4/16
 * @Version: 1.0
 **/
public class DifferPositionWords {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> stringMap = new HashMap<>();
        for (String s : strs){
            char[] stringChars = s.toCharArray();
            Arrays.sort(stringChars);
            String stringOrder = String.valueOf(stringChars);
            List<String> differPositionWords = stringMap.get(stringOrder);
            if (differPositionWords == null){
                differPositionWords = new ArrayList<>();
                stringMap.put(stringOrder,differPositionWords);
            }
            differPositionWords.add(s);
        }
        List<List<String>> wordGroup = new ArrayList<>(stringMap.size());
        for (List<String> entry : stringMap.values()){
            wordGroup.add(entry);
        }
        return wordGroup;
    }
}
