package linknode;

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.HashMap;
public class Clone {
    public RandomListNode clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        //head 新链表头，深拷贝，需要new
        RandomListNode head = new RandomListNode(pHead.label);
        //浅拷贝负责循环
        RandomListNode p = head;
        //旧链表头
        RandomListNode cur = pHead;
        while(pHead !=null){
            map.put(pHead,new RandomListNode(pHead.label));
            pHead = pHead.next;
        }
        while(cur!=null){
            p.next = map.get(cur.next);
            p.random = map.get(cur.random);
            cur = cur.next;
            p = p.next;
        }
        return head;
    }
}
