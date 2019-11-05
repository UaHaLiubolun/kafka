/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.Rob
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Rob
 * @description TODO
 * @author liubolun
 * @date 2019年11月05日 22:13
 * @version 2.9
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }
        int p1 = dp[nums.length - 1];
        int[] dp2 = new int[nums.length + 1];
        dp[2] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i] + dp2[i - 2]);
        }
        return Math.max(p1, dp2[nums.length]);
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left);
            val += rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left);
            val += rob(root.right.right);
        }
        return Math.max(rob(root.left) + rob(root.right), val);
    }

    private void rob(List<Integer> integers, TreeNode treeNode, boolean isFalse) {
        if (treeNode == null) {
            return;
        }
        if (isFalse) {
            integers.set(0, integers.get(0) + treeNode.val);
        } else {
            integers.set(1, integers.get(1) + treeNode.val);
        }
        rob(integers, treeNode.left, !isFalse);
        rob(integers, treeNode.right, !isFalse);
    }
}
