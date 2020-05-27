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
---------------------------
+ Clone.java ：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
+ FindFirstCommonNode：求两个链表的公共节点
+ ListNodeMerge.java ：合并链表
