package Tree;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * �ڵ���
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
			result.add(new ArrayList<Integer>(list));// ���Ƶ�ǰlist����������result����һ��list
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);// ���ݣ��Ѳ����ϵ�����ӵĽڵ�ɾ����������һ��֧
		return result;
	}
	
	@Test //���Է���
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
