/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if( head ==null) return null;
        Node pre = head;
        Node cur = pre;
        HashMap<Node,Node> map = new HashMap<>();
        while(pre != null){
            map.put(pre,new Node(pre.val,null,null));
            pre = pre.next;
        }
        while(cur !=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
