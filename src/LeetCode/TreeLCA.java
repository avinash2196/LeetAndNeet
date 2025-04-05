package LeetCode;

public class TreeLCA {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root,p,q);
        return ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return false;

        int left=recurseTree(root.left,p,q)?1:0;
        int right=recurseTree(root.right,p,q)?1:0;

        int mid=(root==p || root==q)?1:0;
        if(mid+left+right >=2)
            ans=root;
        return mid+left+right>0;
    }
}