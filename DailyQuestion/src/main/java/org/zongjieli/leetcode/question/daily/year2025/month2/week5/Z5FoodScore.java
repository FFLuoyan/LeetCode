package org.zongjieli.leetcode.question.daily.year2025.month2.week5;

import java.util.*;

/**
 * 设计一个支持下述操作的食物评分系统:
 *  修改系统中列出的某种食物的评分
 *  返回系统中某一类烹饪方式下评分最高的食物
 *
 * 实现 Z5FoodScore 类:
 *  FoodRatings(String[] foods, String[] cuisines, int[] ratings):
 *      初始化系统,食物由 foods、cuisines 和 ratings 描述,长度均为 n
 *      foods[i] 是第 i 种食物的名字
 *      cuisines[i] 是第 i 种食物的烹饪方式
 *      ratings[i] 是第 i 种食物的最初评分
 *  void changeRating(String food, int newRating):
 *      修改名字为 food 的食物的评分
 *  String highestRated(String cuisine):
 *      返回指定烹饪方式 cuisine 下评分最高的食物的名字
 *      如果存在并列,返回字典序较小的名字
 * 注意,字符串 x 的字典序比字符串 y 更小的前提是:
 *  x 在字典中出现的位置在 y 之前,也就是说,要么 x 是 y 的前缀
 *  或者在满足 x[i] != y[i] 的第一个位置 i 处,x[i] 在字母表中出现的位置在 y[i] 之前
 *
 * 1 <= n <= 2 * 10^4
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 10^8
 * foods 中的所有字符串互不相同
 * 在对 changeRating 的所有调用中,food 是系统中食物的名字
 * 在对 highestRated 的所有调用中,cuisine 是系统中至少一种食物的烹饪方式
 * 最多调用 changeRating 和 highestRated 总计 2 * 10^4 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/2/28
 */
public class Z5FoodScore {

    // 值中的排序需要按照食物对应的评分
    Map<String, TreeSet<String>> cuisineFoods;

    Map<String, Integer> foodScores;

    Map<String, String> foodCuisine;

    public Z5FoodScore(String[] foods, String[] cuisines, int[] ratings) {
        foodScores = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            foodScores.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            TreeSet<String> currentCuisine = cuisineFoods.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                int scoreA = foodScores.get(a), scoreB = foodScores.get(b);
                if (scoreA == scoreB) {
                    return a.compareTo(b);
                }
                return Integer.compare(scoreB, scoreA);
            }));
            currentCuisine.add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        TreeSet<String> currentCuisine = cuisineFoods.get(cuisine);
        currentCuisine.remove(food);
        foodScores.put(food, newRating);
        currentCuisine.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }

    public static void main(String[] args) {
        Z5FoodScore test = new Z5FoodScore(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        // kimchi
        System.out.println(test.highestRated("korean"));
        // ramen
        System.out.println(test.highestRated("japanese"));
        test.changeRating("sushi", 16);
        // sushi
        System.out.println(test.highestRated("japanese"));
        test.changeRating("ramen", 16);
        // ramen
        System.out.println(test.highestRated("japanese"));

        test = new Z5FoodScore(new String[]{"czopaaeyl","lxoozsbh","kbaxapl"}, new String[]{"dmnuqeatj","dmnuqeatj","dmnuqeatj"}, new int[]{11, 2, 15});
        test.changeRating("czopaaeyl", 12);
        // kbaxapl
        System.out.println(test.highestRated("dmnuqeatj"));
        test.changeRating("kbaxapl", 8);
        test.changeRating("lxoozsbh", 5);
        // czopaaeyl
        System.out.println(test.highestRated("dmnuqeatj"));
    }

}
