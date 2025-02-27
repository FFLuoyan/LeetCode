package org.zongjieli.leetcode.question.daily.year2022.month3.week2;

import org.zongjieli.leetcode.base.Tree;
import org.zongjieli.leetcode.origin.collection.ntree.NTreePreorder;

import java.util.List;

/**
 * @see NTreePreorder
 *
 * @author   Li.zongjie
 * @date     2022/3/10
 * @version  1.0
 */
public class Z4TreePreorder {

    public List<Integer> preorder(Tree root) {
        return new NTreePreorder().preorder(root);
    }

}
