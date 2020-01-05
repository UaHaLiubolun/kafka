/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.WidthOfBinaryTree
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * WidthOfBinaryTree
 * @description TODO
 * @author liubolun
 * @date 2020年01月02日 15:15
 * @version 3.1.1
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> list = new LinkedList<>();
        trans(list, root, 0, 0);
        int max = 0;
        for (List<Integer> i : list) {
            if (i.size() == 0) continue;
            i.sort(Integer::compareTo);
            max = Math.max(i.get(i.size() - 1) - i.get(0), max);
        }
        return max + 1;
    }

    private void trans(List<List<Integer>> list, TreeNode node, int index, int row) {
        if (node == null) {
            return;
        }
        if (list.size() <= row) {
            list.add(new ArrayList<>());
        }
        list.get(row).add(index);
        row++;
        index *= 2;
        trans(list, node.left, index, row);
        trans(list, node.right, index + 1, row);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode  = WidthOfBinaryTree.stringToTreeNode("[1,3,2,5,3,null,9]");
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        widthOfBinaryTree.widthOfBinaryTree(treeNode);
    }
}
