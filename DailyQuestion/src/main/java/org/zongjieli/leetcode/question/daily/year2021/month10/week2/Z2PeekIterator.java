package org.zongjieli.leetcode.question.daily.year2021.month10.week2;

import java.util.Iterator;

/**
 * 请设计一个迭代器,除了支持 hasNext 和 next 操作外,还支持 peek 操作
 *
 * 实现 PeekingIterator 类
 *  PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器
 *  int next() 返回数组中的下一个元素,并将指针移动到下个元素处
 *  bool hasNext() 如果数组中存在下一个元素,返回 true,否则返回 false
 *  int peek() 返回数组中的下一个元素,但不移动指针
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 对 next 和 peek 的调用均有效
 * next、hasNext 和 peek 最多调用  1000 次
 *
 * @author   Li.zongjie
 * @date     2021/10/18
 * @version  1.0
 */
public class Z2PeekIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private boolean isPeek;

    private boolean peakNext;
    private int peekValue;

    public Z2PeekIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (isPeek){
            return peekValue;
        }
        isPeek = true;
        peakNext = iterator.hasNext();
        return peekValue = iterator.next();
    }

    @Override
    public Integer next() {
        if (isPeek){
            isPeek = false;
            return peekValue;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (isPeek){
            return peakNext;
        }
        return iterator.hasNext();
    }
}
