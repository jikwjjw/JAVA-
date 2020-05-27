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
public class IsBalanced_Solution {
	public boolean isBalanced_Solution(TreeNode root) {
        if(root ==null){
            return true;
        }
        //�ж����������߶Ȳ�
        if(Math.abs(TreeDepth(root.left)-TreeDepth(root.right))>1){
            return false;
        }
        //����������Ҳ�ж��Ƿ���ƽ����������жϺ���Ϊ���������ݹ���á�
        return isBalanced_Solution(root.left) && isBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {
        if(root==null){
        return 0;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
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
 		System.out.println(isBalanced_Solution(t10));
 	}
}
