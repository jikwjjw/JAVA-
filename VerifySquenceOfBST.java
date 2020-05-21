package Tree;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。 假设输入的数组的任意两个数字都互不相同。
 * 
 * @author ji
 *
 */
/*
 * public class TreeNode{ int val =0; TreeNode.left =null; TreeNode.right =null;
 * public TreeNode(int val) { this.val = val; } }
 */

public class VerifySquenceOfBST {
	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		return isBST(sequence, 0, sequence.length - 1);
	}

	public boolean isBST(int[] sequence, int start, int end) {
		if(start >= end) return true;
		int i = 0;
		int root = sequence[end];
		//找到左右子树的分界点
		for (i = start; i < end; i++) {
			if(sequence[i] > root){
				break;
			}
		}
		//在右子树中判断是否含有小于root的值，如果有返回false
		for(int j = i;j<end;j++){
			if(sequence[j] < root){
				return false;
			}
		}
		return isBST(sequence, start, i-1) && isBST(sequence, i, end-1);
	}
}
