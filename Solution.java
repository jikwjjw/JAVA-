package test;
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList =new ArrayList<>();
        ListNode temp = listNode;
        while(temp!=null){
            arrayList.add(0,temp.val);
            temp = temp.next;
        }
        return arrayList;
    }
}