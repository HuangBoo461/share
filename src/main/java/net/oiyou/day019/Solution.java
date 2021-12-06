package net.oiyou.day019;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pa = head;
        ListNode pb = head;

        // 找到第n个结点
        for (int i = 0; i < n && pa != null; i++) {
            pa = pa.next;
        }


        // 说明要删除第一个节点
        if (pa == null) {
            head = head.next;
            return head;
        }

        // pb与pa相差n-1个结点
        // 当pa.next为null，pb在倒数第n+1个位置
        while (pa.next != null) {
            pa = pa.next;
            pb = pb.next;
        }

        pb.next = pb.next.next;

        return head;
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
