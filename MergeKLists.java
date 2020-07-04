package listnode;

import org.junit.Test;

/**
 * 合并多个有序链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode node = deep(lists,0,lists.length-1);
        return node;
    }
    public ListNode deep(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode l1 = deep(lists, left, mid);
        ListNode l2 = deep(lists, mid+1, right);
        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
