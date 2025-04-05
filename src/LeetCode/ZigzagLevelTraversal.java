package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRightFlag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> currLayer = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (leftToRightFlag)
                    currLayer.addLast(node.val);
                else
                    currLayer.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(currLayer);
            leftToRightFlag = !leftToRightFlag;
        }
        return result;
    }
}
