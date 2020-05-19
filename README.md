# JAVA链表
+ 链表节点
```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
```
------------------------------
+ 链表计数
```
int totalNum = 0;
ListNode currentNode = head;
while(currentNode != null){
  totalNum++;
currentNode = currentNode.next;
}
```
