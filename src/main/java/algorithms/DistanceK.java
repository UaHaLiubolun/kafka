/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.DistanceK
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * DistanceK
 * @description TODO
 * @author liubolun
 * @date 2019年11月04日 21:07
 * @version 2.9
 */
public class DistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        List<Integer> integers = new LinkedList<>();
        if (root.equals(target)) {
            findSon(target, integers, K);
        } else {
            findSon(target, integers, K);
            findParent(parent, root, parent.get(target), target, integers, K - 1);
        }
        return integers;
    }

    private void findParent(Map<TreeNode, TreeNode> parent, TreeNode root, TreeNode current, TreeNode qzNode, List<Integer> value, int k) {
        if (current == null || qzNode == null) {
            return;
        }
        if (k == 0) {
            value.add(current.val);
            return;
        }
        TreeNode father = parent.get(current);
        if (father != null) {
            findParent(parent, root, father, current, value, k - 1);
        } else {
            father = root;
            current = qzNode;
        }
        if (current.equals(father.left)) {
            findSon(father.right, value, k - 1);
        } else {
            findSon(father.left, value, k -1);
        }
    }

    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
            dfs(node.left, map);
        }
        if (node.right != null) {
            map.put(node.right, node);
            dfs(node.right, map);
        }
    }

    private void findSon(TreeNode target, List<Integer> value, int k) {
        if (target == null) {
            return;
        }
        if (k == 0) {
            value.add(target.val);
        }
        findSon(target.left, value, k -1);
        findSon(target.right, value, k -1);
    }
}
