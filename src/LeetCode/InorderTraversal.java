package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

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

    public List<Integer> recursiveInorder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        recursiveTraversalHelper(node, result);
        return result;
    }

    private void recursiveTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        recursiveTraversalHelper(node.left, result);
        result.add(node.val);
        recursiveTraversalHelper(node.left, result);
    }

    public List<Integer> inorderStackTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = node;
        while (curr != null && !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;

        }
        return result;
    }
}
