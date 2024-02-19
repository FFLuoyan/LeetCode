package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.Tree;
import org.zongjieli.leetcode.origin.year2024.NTreeLevelOrder;

import java.util.List;

/**
 * @see NTreeLevelOrder
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/18
 */
public class Z6NTree {

    public List<List<Integer>> levelOrder(Tree root) {
        return new NTreeLevelOrder().levelOrder(root);
    }

}
