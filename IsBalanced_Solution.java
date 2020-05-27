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
        //判断左右子树高度差
        if(Math.abs(TreeDepth(root.left)-TreeDepth(root.right))>1){
            return false;
        }
        //对左右子树也判断是否都是平衡二叉树，判断函数为函数自身，递归调用。
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
    
    @Test //测试方法
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
