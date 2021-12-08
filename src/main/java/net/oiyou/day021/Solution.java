package net.oiyou.day021;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 创建一个头结点，最后还要删除掉
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            // 移动到新的尾结点
            tail = tail.next;
        }

        tail.next = (l1 != null ? l1 : l2);

        // head的下一个节点是第一个数据结点
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
