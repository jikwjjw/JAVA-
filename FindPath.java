package Tree;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 节点类
 * @author ji
 *
 */
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class FindPath {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null || target == 0) {
			return result;
		}
		list.add(root.val);
		target = target - root.val;
		if (target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(list));// 复制当前list，否则所有result共用一个list
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);// 回溯，把不符合的已添加的节点删除，进入另一分支
		return result;
	}
	
	@Test //测试方法
	public void test() {
		TreeNode t10 = new TreeNode(10);
		TreeNode t5 = new TreeNode(5);
		TreeNode t12 = new TreeNode(12);
		TreeNode t7 = new TreeNode(7);

		t10.left = t12;
		t10.right = t5;
		t12.left = t7;
		ArrayList<ArrayList<Integer>> res = FindPath(t10, 29);
		for (ArrayList<Integer> path : res)
			System.out.println(path);
	}
	
	
}
