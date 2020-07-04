/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(-1);
        ListNode pre = cur;
        cur.next = head;
        while(head != null && head.next !=null){
            ListNode first = head;
            ListNode second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre  = first;
            head = first.next;
        }
        return cur.next;
    }
}
