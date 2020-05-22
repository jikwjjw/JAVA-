package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印

/*public class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = int val;
	}
}*/

/**
 * 利用队列进行二叉树的广度优先遍历
 * 
 * @author ji
 *
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> alist = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>;
		queue.offer(root);
		if(root==null) return alist;
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			alist.add(temp.val);
			if(temp.left !=null) queue.offer(temp.left);
			if(temp.right !=null) queue.offer(temp.right);
		}
		return alist;
	}
}
