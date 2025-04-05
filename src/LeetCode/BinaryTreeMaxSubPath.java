package LeetCode;

public class BinaryTreeMaxSubPath {

    public class TreeNode {
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

    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainFromSubTree(root);
        return maxPath;
    }

    private int gainFromSubTree(TreeNode root) {
        if (root == null) return 0;
//            use DFS to get all subtree
        int leftGain = Math.max(gainFromSubTree(root.left), 0);
        int rightGain = Math.max(gainFromSubTree(root.right), 0);
        maxPath = Math.max(maxPath, leftGain + rightGain + root.val);
        //return only as this is going for parent and adding both will convert it into y
        return Math.max(leftGain + root.val, rightGain + root.val);
    }
}
