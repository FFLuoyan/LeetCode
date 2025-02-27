package org.zongjieli.leetcode.base;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * NestedInteger
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/4/15
 */

@ToString
public class NestedInteger {

    private Integer value;
    private List<NestedInteger> list;

    public NestedInteger(){
        this.list = new ArrayList<>();
    }

    public NestedInteger(int value){
        this.value = value;
        this.list = new ArrayList<>();
    }

    public boolean isInteger() {
        return list.isEmpty();
    }

    public Integer getInteger() {
        return list.isEmpty() ? value : null;
    }

    public void setInteger(int value) {
        this.value = value;
        this.list.clear();
    }

    public void add(NestedInteger ni) {
        this.value = null;
        this.list.add(ni);
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}
