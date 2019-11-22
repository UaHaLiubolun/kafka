/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.IsSymmetric
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * IsSymmetric
 * @description TODO
 * @author liubolun
 * @date 2019年11月22日 14:42
 * @version 3.1.1
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return is(root.left, root.right);
    }


    private boolean is(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return true;
        } else if (nodeLeft == null || nodeRight == null) {
            return false;
        } else {
            return nodeLeft.val == nodeRight.val && is(nodeLeft.left, nodeRight.right) && is(nodeLeft.right, nodeRight.left);
        }
    }
}
