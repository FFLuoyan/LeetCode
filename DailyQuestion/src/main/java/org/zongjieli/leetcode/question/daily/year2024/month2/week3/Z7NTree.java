package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.Tree;
import org.zongjieli.leetcode.origin.year2024.NTreePreorder;

import java.util.List;

/**
 * @see NTreePreorder
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/18
 */
public class Z7NTree {

    public List<Integer> preorder(Tree root) {
        return new NTreePreorder().preorder(root);
    }

}
