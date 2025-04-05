package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node,Node> visitedNode=new HashMap<>();
    public Node copyRandomList(Node head) {

        if(head==null)
            return null;
        Node oldNode=head;
        Node newHead=new Node(oldNode.val);
        visitedNode.put(oldNode,newHead);
        while(oldNode!=null){
            newHead.next=this.getClonedNode(oldNode.next);
            newHead.random=this.getClonedNode(oldNode.random);
            newHead=newHead.next;
            oldNode=oldNode.next;
        }
        return this.visitedNode.get(head);
    }

    private Node getClonedNode(Node node) {
        if(node==null)
            return null;
        if(visitedNode.containsKey(node))
            return visitedNode.get(node);
        else{
            Node newNode=new Node(node.val);
            visitedNode.put(node,newNode);
            return newNode;
        }
    }
}
