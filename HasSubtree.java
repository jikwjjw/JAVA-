package Tree;

/*public class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}*/
public class HasSubtree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		// ����ҵ���������ͬ����ֵ�����жϷ���
		if (root1.val == root2.val) {
			if (judge(root1, root2)) {
				return true;
			}
		}
		// ������������������������ͬ�ĸ�ֵ
		return HasSubtree(root1.left, root2) || HasSubtree(root1.rigth, root2);
	}

	public boolean judge(TreeNode root, TreeNode subtree) {
		//�ӽṹ�Ѿ�ѭ����ϣ�����ȫ��ƥ��
		if (subtree == null) {
			return true;
		}
		//�����Ѿ�ȫ����ϣ���δƥ��ɹ�
		if (root == null) {
			return true;
		}
		//���ڵ���ȣ��ж����Һ��ӽڵ�
		if (root.val == subtree.val) {
			return judge(root.left, subtree.left) && judge(root.right, subtree.right);
		}
	}
}
