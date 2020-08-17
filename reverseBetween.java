/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        int index  = n-m;
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = head;
        while( m > 1){
            pre = tail;
            tail = tail.next;
            m--;
        }
        while(index > 0){
            ListNode next = tail.next;
            tail.next =next.next;
            next.next = pre.next;
            pre.next = next;
            index--;
        }
        return dummy.next;
    }
}
