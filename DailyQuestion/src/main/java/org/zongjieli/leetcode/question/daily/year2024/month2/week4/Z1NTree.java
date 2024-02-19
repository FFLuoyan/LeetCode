package org.zongjieli.leetcode.question.daily.year2024.month2.week4;

import org.zongjieli.leetcode.base.Tree;
import org.zongjieli.leetcode.origin.year2024.NTreePostorder;

import java.util.List;

/**
 * @see NTreePostorder
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class Z1NTree {

    public List<Integer> postorder(Tree root) {
        return new NTreePostorder().postorder(root);
    }

}
