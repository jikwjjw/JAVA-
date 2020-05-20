package Tree;

import java.util.Stack;


//���������Ķ�����������任ΪԴ�������ľ���

/*public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}*/

public class MirrorTree {
	public void mirror(TreeNode root) {
		// �ݹ齻������
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	/**
	 * ����ջ����������
	 * continue����������ѭ��
	 * ʹ��continueΪ������ȱ�������Ҷ�ڵ�ʱ��ջ�е��ѽ����Ľڵ��ȥ��ֻʣ��Ҫ�����Ľڵ�
	 * @param root
	 */
	public void mirror2(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = null;
		TreeNode temp = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if(cur = null){
				continue;//��������ѭ����������δִ�е���䣬����������ѭ��
			}
			if(cur.left == null && cur.right==null) {
                continue;//��ȱ������������
            }
			temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			stack.push(cur.left);
			stack.push(cur.right);
		}
	}
}
