package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraveral {
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

    public List<Integer> postOrderRecursiveTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        postOrderRecursiveTraversalHelper(node, result);
        return result;
    }

    private void postOrderRecursiveTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postOrderRecursiveTraversalHelper(node.left, result);
        postOrderRecursiveTraversalHelper(node.right, result);
        result.add(node.val);
    }

    public List<Integer> postOrderStackTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reverseStack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            reverseStack.push(curr);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        while (!reverseStack.isEmpty()) {
            result.add(reverseStack.pop().val);
        }
        return result;

    }
}
