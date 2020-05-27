package Tree;

import org.junit.Test;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ�������
 * @author ji
 *
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if(root==null){
        return 0;
    }
        
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        int count =Math.max(left,right)+1;
        return count;
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
		System.out.println(treeDepth(t10));
	}
}
