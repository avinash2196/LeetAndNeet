package LeetCode;

public class ValidBSTTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    //need to maintain high and low as not just left node needs to be less than root but whole left subtree
    public boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        if ((low != null && root.val <= low) ||
                (high != null && root.val >= high))
            return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
    Integer prev=null;
    public boolean isValidBST1(TreeNode root){
        prev=null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if(root==null)
            return true;
        if(!inorder(root.left))
            return false;

        if(prev!=null && root.val>=prev)
            return false;
        prev=root.val;
        return inorder(root.right);
    }
}
