package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recursiveSerialize(root, "");
    }

    private String recursiveSerialize(TreeNode root, String s) {
        if (root == null) return s + "null,";
        else {
            s = s + root.val + ",";
            s = recursiveSerialize(root.left, s);
            s = recursiveSerialize(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return recursiveDeserialize(list);
    }

    private TreeNode recursiveDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = recursiveDeserialize(list);
        node.right = recursiveDeserialize(list);
        return node;
    }
}
