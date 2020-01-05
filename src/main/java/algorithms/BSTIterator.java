/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.BSTIterator
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * BSTIterator
 * @description TODO
 * @author liubolun
 * @date 2020年01月02日 14:17
 * @version 3.1.1
 */
public class BSTIterator {

    private int current;

    private List<Integer> allNode = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        init(root);
        allNode.sort(Integer::compareTo);
    }

    private void init(TreeNode node) {
        if (node == null) {
            return;
        }
        allNode.add(node.val);
        init(node.left);
        init(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (current >= allNode.size()) {
            return 0;
        }
        int i = allNode.get(current);
        current++;
        return i;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current < allNode.size();
    }
}
