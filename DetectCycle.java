package letcode.tree;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 快慢指针
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        //获取首次相遇时候，slow的位置
        if (fast == null || fast.next == null) return null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        // 环形入口
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
