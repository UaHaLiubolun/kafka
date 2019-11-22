/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.DetectCycle
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DetectCycle
 * @description TODO
 * @author liubolun
 * @date 2019年11月22日 14:53
 * @version 3.1.1
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (true) {
            if (one == null) {
                return false;
            }
            one = one.next;
            if (one == null) {
                return false;
            }
            two = two.next;
            if (two == null) {
                return false;
            }
            two = two.next;
            if (one.equals(two)) {
                return true;
            }
        }
    }
}
