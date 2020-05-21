package Tree;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ���� ����������Yes,�������No�� �������������������������ֶ�������ͬ��
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
		//�ҵ����������ķֽ��
		for (i = start; i < end; i++) {
			if(sequence[i] > root){
				break;
			}
		}
		//�����������ж��Ƿ���С��root��ֵ������з���false
		for(int j = i;j<end;j++){
			if(sequence[j] < root){
				return false;
			}
		}
		return isBST(sequence, start, i-1) && isBST(sequence, i, end-1);
	}
}
