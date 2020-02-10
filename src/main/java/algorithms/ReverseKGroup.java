/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.ReverseKGroup
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.List;
import java.util.Stack;

/**
 * ReverseKGroup
 * @description TODO
 * @author liubolun
 * @date 2020年02月06日 15:33
 * @version 2.9
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode tempHead = newHead;
        ListNode headOne = head;
        int i = k;
        Stack<ListNode> stack = new Stack<>();
        while (headOne != null) {
            while (i != 0 && headOne != null) {
                stack.push(headOne);
                headOne = headOne.next;
                i--;
            }
            if (i != 0) {
                Stack<ListNode> newStack = new Stack<>();
                while (!stack.isEmpty()) {
                    newStack.push(stack.pop());
                }
                stack = newStack;
            }
            while (!stack.isEmpty()) {
                newHead.next = stack.pop();
                newHead = newHead.next;
            }
            i = k;
            stack.empty();
            newHead.next = null;
        }

        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(1);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(one, 2);
    }
}
