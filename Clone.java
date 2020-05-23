package linknode;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
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
        //head ������ͷ���������Ҫnew
        RandomListNode head = new RandomListNode(pHead.label);
        //ǳ��������ѭ��
        RandomListNode p = head;
        //������ͷ
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