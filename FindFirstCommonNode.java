package linknode;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 看下面的链表例子：0-1-2-3-4-5-null
a-b-4-5-null
代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
因此，两个指针所要遍历的链表就长度一样了！
如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
 * @author ji
 *
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1==null?pHead2:p1.next;
            p2 = p2==null?pHead1:p2.next;
        }
        return p1;
    }
}
