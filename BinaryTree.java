package letcode.tree;

/**
 * 关键是：利用前序序列根节点在前找到根节点，
 * 用根节点去中序序列划分成两部分，左部分是左子树，右部分是右子树。
 * 再利用子树长度去前序序列把前序序列中的左右子树找出来，同时可以找出根节点。
 * 递归进行此步骤，如果子树长度为0，则不需要生成子问题。
 */


public class BuildTree {
    /**
     * 递归和二分思想，将问题不断划分，直到问题容易解决。
     * 做法是：对于一个根节点，先去中序序列中找到根节点的值所在位置，利用这个位置分成2部分，左部分的中序序列长度即为前序序列中左部分的中序序列长度，右部分亦然。
     * 然后开始生成子问题，如果序列长度为0则不需要生成子问题。否则：利用前序序列第一个元素为根节点的性质生成根节点，然后构造子问题。
     *
     * @param root     根节点
     * @param preorder 前序序列 范围是[pleft,pright)
     * @param inorder  中序序列 范围是[ileft,iright)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper1(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 根据前序和中序构建二叉树
     *
     * @param preorder 前序
     * @param p_start
     * @param p_end
     * @param inorder  中序
     * @param i_start
     * @param i_end
     * @return
     */
    private TreeNode buildTreeHelper1(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = 0;
        for (int i = p_start; i < p_end; i++) {
            if (root_val == preorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int left_num = i_root_index - i_start;
        root.left = buildTreeHelper1(preorder, p_start + 1, p_start + 1 + left_num, inorder, i_start, i_root_index);
        root.right = buildTreeHelper1(preorder, p_start + 1 + left_num, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    /**
     * @param inorder   中序
     * @param i_start
     * @param i_end
     * @param postorder 后序
     * @param p_start
     * @param p_end
     * @return
     */
    private TreeNode buildTreeHelper2(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        if (p_start >= p_end) return null;
        int root_val = postorder[p_end - 1];
        TreeNode root = new TreeNode(root_val);
        int root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                root_index = i;
                break;
            }
        }
        int left_num = root_index - i_start;
        root.left = buildTreeHelper2(inorder, i_start, root_index, postorder, p_start, p_start + left_num);
        root.right = buildTreeHelper2(inorder, root_index + 1, i_end, postorder, p_start + left_num, p_end - 1);
        return root;
    }
}
