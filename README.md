+ 前序遍历：访问根结点的操作发生在遍历其左右子树之前。根左右
+ 中序遍历：访问根结点的操作发生在遍历其左右子树之中。左根右
+ 后序遍历：访问根结点的操作发生在遍历其左右子树之后。左右根
-----------------------------------------
```
/*public class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}*/
```
---------------------------------------
+ BinaryTree:根据前序和中序遍历结果，构建树
+ HasSubtree：是否含有子树结构
+ MirrorTree：树的镜像，采用递归和栈的方式
