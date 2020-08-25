package letcode;

/**
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode pre = new ListNode(head.val);
        ListNode node = pre;
        ListNode cur = head;
        while (cur.next != null) {
            pre.next = new ListNode(cur.next.val);
            cur = cur.next;
            pre = pre.next;
        }
        node = ReverseList(node);

        while (head != null && node != null) {
            if (head.val != node.val) {
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null; //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode p = null; //初始化p指针，用于记录当前结点的下一个结点地址
        while (head != null) {
            p = head.next;//当前节点的后一个节点
            head.next = pre;//当前节点的前一个结点
            pre = head;//pre往右走
            head = p;//当前节点往右继续走
        }

        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }


    /**
     * 快慢指针，反转一半即可
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        //1.快慢指针,找到链表的中点。
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //2.将slow之后链表反转
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        //3.前后链表进行比较，注意若为奇数链表，多1一个节点，然而并不影响判断回文
        while (head != null && pre != null) {
            if (head.val != pre.val) return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }
}
