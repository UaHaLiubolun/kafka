/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.Partition
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.List;

/**
 * Partition
 * @description TODO
 * @author liubolun
 * @date 2019年11月22日 15:38
 * @version 3.1.1
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode lowHead = new ListNode(0);
        ListNode highHead = new ListNode(0);
        ListNode low = lowHead;
        ListNode high = highHead;
        while (head != null) {
            if (head.val < x) {
                low.next = head;
                low = low.next;
            } else {
                high.next = head;
                high = high.next;
            }
            head = head.next;
        }
        high.next = null;
        low.next = highHead.next;
        return lowHead.next;
    }

}
