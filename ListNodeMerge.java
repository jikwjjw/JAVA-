package test;

public class ListNodeMerge {
	   public ListNode Merge(ListNode list1,ListNode list2) {
	       ListNode node = new ListNode(0);//����ͷ
	       ListNode h = node;//����β
	       while(list1!=null&&list2!=null){
	           if(list1.val<=list2.val){
	               h.next = list1;
	               list1 = list1.next;
	           }else{
	               h.next = list2;
	               list2 = list2.next;
	           }
	           h = h.next;
	       }
	     //��֤���������һ��������ӵ�������h��
	        if(list1!=null){
	            h.next = list1;
	        }
	        if(list2!=null){
	            h.next = list2;
	        }
	        return node.next;
	    }
}
