package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import org.zongjieli.leetcode.base.Tree;
import org.zongjieli.leetcode.origin.collection.ntree.NTreeLevelOrder;

import java.util.List;

/**
 * @see NTreeLevelOrder
 *
 * @author   Li.zongjie
 * @date     2022/4/8
 * @version  1.0
 */
public class Z5NthTreeErgodic {

    public List<List<Integer>> levelOrder(Tree root) {
        return new NTreeLevelOrder().levelOrder(root);
    }

}
