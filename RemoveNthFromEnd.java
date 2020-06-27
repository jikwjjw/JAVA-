package linknode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @author ji
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode cur = node;
        //距离间隔
        for(int i =1;i<=n+1;i++){
            pre = pre.next;
        }
        //pre和cur一直保持n个距离,直到pre到最后
        while(pre!=null){
            pre = pre.next;
            cur = cur.next;
        }//删除节点
        cur.next = cur.next.next;
        return node.next;
    }
}