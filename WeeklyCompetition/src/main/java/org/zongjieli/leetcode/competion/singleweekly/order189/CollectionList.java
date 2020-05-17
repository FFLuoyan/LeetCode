package org.zongjieli.leetcode.competion.singleweekly.order189;

import java.util.*;

/**
 * @ClassName: CollectionList
 * @Description: 找出收藏清单
 *               给定一个数组 favoriteCompanies,其中 favoriteCompanies[i]
 *               是第 i 名用户收藏的公司清单
 *               请找出不是其他任何人收藏的公司清单的子集的收藏清单
 *               并返回该清单下标,下标需要按升序排列
 *
 *               对于给定的收藏清单 List
 *               每个人可能有多个喜欢公司的收藏清单
 *               如果一个人的收藏清单是其他人收藏清单的子集
 *               则该清单不被返回
 *               如果该收藏清单(List 中的某一项元素)
 *               是其他人收藏清单的子集
 *               则将该下标返回
 * @Author: Zongjie.Li
 * @Date: 2020/5/17
 * @Version: 1.0
 **/
public class CollectionList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 用于校验下标是否为其他人收藏清单的子集
        Map<Integer,Boolean> checkSub = new HashMap<>(favoriteCompanies.size());
        // 获取公司下标
        Map<String,Integer> companyIndexesMap = new HashMap<>();
        int companyMapIndex = 0;

        // 获取对应下标的公司 List
        Map<Integer, Set<Integer>> companyMap = new HashMap<>();

        // 流程解析
        // 先将自己的收藏清单放入映射表中
        //     获取公司表下标,如果不存在,+1 后放入 Map 中
        // 再根据当前遍历的收藏清单
        //     遍历已经存在收藏清单(如果为 false 才遍历)
        //         如果遍历中的收藏清单不为该清单的子集,则不进行任何操作
        //         如果为子集,则将该清单设置为 true,表示是他人的子集
        // 最后返回不为他人收藏清单子集的下标 List

        for (int i = 0 ; i < favoriteCompanies.size() ; i++){
            List<String> companies = favoriteCompanies.get(i);
            Set<Integer> companyIndexes = new HashSet<>(companies.size());

            for (int j = 0 ; j < companies.size() ; j ++){
                String companyName = companies.get(j);
                Integer companyIndex = companyIndexesMap.get(companyName);
                if (companyIndex == null){
                    // 公司不存在
                    companyIndex = companyMapIndex++;
                    companyIndexesMap.put(companyName,companyIndex);
                }
                companyIndexes.add(companyIndex);
            }

            Iterator<Map.Entry<Integer,Set<Integer>>> entrySetIterator = companyMap.entrySet().iterator();

            boolean isOtherSub = false;
            while (entrySetIterator.hasNext()){
                Map.Entry<Integer,Set<Integer>> companyEntry = entrySetIterator.next();
                Integer companyIndex = companyEntry.getKey();
                if (checkSub.get(companyIndex)){
                    continue;
                }
                int equalCount = 0;
                Set<Integer> companySet = companyEntry.getValue();
                for (Integer index : companySet){
                    if (companyIndexes.contains(index)){
                        equalCount ++;
                    }
                }
                if (equalCount == companySet.size()){
                    checkSub.put(companyIndex,true);
                }
                if (equalCount == companyIndexes.size()){
                    isOtherSub = true;
                }
            }
            checkSub.put(i,isOtherSub);
            companyMap.put(i,companyIndexes);
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Map.Entry<Integer,Boolean>> resultEntryIterator = checkSub.entrySet().iterator();
        while (resultEntryIterator.hasNext()){
            Map.Entry<Integer,Boolean> resultEntry = resultEntryIterator.next();
            if (!resultEntry.getValue()){
                result.add(resultEntry.getKey());
            }
        }
        return result;
    }
}
