/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.MergeKLists
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * MergeKLists
 * @description TODO
 * @author liubolun
 * @date 2019年11月14日 20:28
 * @version 2.9
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        ListNode head = null;
        while (true) {
            int min = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == Integer.MAX_VALUE) break;

            ListNode listNode = lists[index];
            lists[index] = listNode.next;
            if (node == null) {
                node = listNode;
                head = node;
            } else {
                node.next = listNode;
                node = node.next;
            }

        }
        return head;
    }
}
