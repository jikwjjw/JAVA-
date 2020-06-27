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
 * ����һ������: 1->2->3->4->5, �� n = 2.
 * ��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
 * @author ji
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode cur = node;
        //������
        for(int i =1;i<=n+1;i++){
            pre = pre.next;
        }
        //pre��curһֱ����n������,ֱ��pre�����
        while(pre!=null){
            pre = pre.next;
            cur = cur.next;
        }//ɾ���ڵ�
        cur.next = cur.next.next;
        return node.next;
    }
}