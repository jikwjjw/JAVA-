/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        for(int i = 0; i<k; i++){
            if(tail == null){
                return head;
            }
            tail = tail.next;
        }
        
        ListNode newNode = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newNode;
    }
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = null;
        ListNode cur = null;
        while(head != tail){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}
