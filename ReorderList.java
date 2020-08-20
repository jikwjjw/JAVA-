package letcode;

import letcode.ListNode;

import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 */
public class ReorderList {
    //使用双端队列
    public static void reorderList1(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //快慢指针，后半段反转
    public static void reorderList2(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        ListNode postHead = reverse(low);
        ListNode p = head, q = postHead;
        while (p != low) {
            ListNode pNext = p.next;
            ListNode qNext = q.next;
            p.next = q;
            if (pNext != low) {
                q.next = pNext;
            }
            p = pNext;
            q = qNext;
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        reorderList2(l1);
    }
}
