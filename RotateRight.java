package LIstNode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateRight {
    /**
     *
     * @param head 1->2->3->4->5->NULL
     * @param k k = 2
     * @return 4->5->1->2->3->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode pre = head;
        int n = 1; //求节点数量
        while (pre.next != null) {
            n++;
            pre = pre.next;
        }
        pre.next = head; //形成环
        ListNode cur = head;
        //找到尾节点，头节点前一个
        for (int i = 0; i < n - k % n - 1; i++) {
            cur = cur.next;
        }
        ListNode new_head = cur.next; //新头节点
        cur.next = null; //断开环
        return new_head;
    }
}
