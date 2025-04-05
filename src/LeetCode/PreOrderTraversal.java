package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
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

    public List<Integer> preOrderRecursiveTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        preOrderRecursiveTraversalHelper(node, result);
        return result;
    }

    private void preOrderRecursiveTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        preOrderRecursiveTraversalHelper(node.left, result);
        preOrderRecursiveTraversalHelper(node.right, result);
    }

    public List<Integer> preOrderStackTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null) stack.push(curr.right); //push right first so that left gets processed first
            if (curr.left != null) stack.push(curr.left);
        }
        return result;
    }
}
