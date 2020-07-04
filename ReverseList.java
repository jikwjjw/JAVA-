/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null; //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode p = null; //初始化p指针，用于记录当前结点的下一个结点地址
        while(head!=null){
            p = head.next;//当前节点的后一个节点
            head.next = pre;;//当前节点的前一个结点
            pre = head;//pre往右走
            head = p;//当前节点往右继续走
        }
        
        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }
}
