package test;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * �ؼ��ǣ�����ǰ�����и��ڵ���ǰ�ҵ����ڵ㣬
 * �ø��ڵ�ȥ�������л��ֳ������֣��󲿷������������Ҳ�������������
 * ��������������ȥǰ�����а�ǰ�������е����������ҳ�����ͬʱ�����ҳ����ڵ㡣
 * �ݹ���д˲��裬�����������Ϊ0������Ҫ���������⡣
 */

/**
     * �ݹ�Ͷ���˼�룬�����ⲻ�ϻ��֣�ֱ���������׽����
     * �����ǣ�����һ�����ڵ㣬��ȥ�����������ҵ����ڵ��ֵ����λ�ã��������λ�÷ֳ�2���֣��󲿷ֵ��������г��ȼ�Ϊǰ���������󲿷ֵ��������г��ȣ��Ҳ�����Ȼ��
     * Ȼ��ʼ���������⣬������г���Ϊ0����Ҫ���������⡣��������ǰ�����е�һ��Ԫ��Ϊ���ڵ���������ɸ��ڵ㣬Ȼ���������⡣
     * @param root ���ڵ�
     * @param pre ǰ������ ��Χ��[pleft,pright)
     * @param in �������� ��Χ��[ileft,iright)
     */
public class BinaryTree {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        
    }
    public void build(TreeNode root, int[] pre, int pleft, int pright, int[] in, int ileft, int iright){
        int i;
        for(int i = ileft;i<irigth;i++){
            if(in[i] == root.val){
                break;
            }
        }
        int t = i - ileft; 
        if (t > 0) {//��������Ϊ0ʱ��������������
            root.left = new TreeNode(pre[pleft + 1]);
            build(root.left, pre, pleft + 1, pleft + 1 + t, in, ileft, i);
        }

        if (pright - pleft - 1 - t > 0) {
            root.right = new TreeNode(pre[pleft + 1 + t]);
            build(root.right, pre, pleft + 1 + t, pright, in, i + 1, iright);
    }
}
