import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
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

public class CopyRandom {

        private final Map<Node,Node> oldToNewMap=new HashMap<Node,Node>();
        public Node copyRandomList(Node head) {
            if(head==null){
                return head;
            }
            Node newHead=new Node(head.val);
            Node node=head;
            oldToNewMap.put(head,newHead);
            while(node!=null){
                newHead.next=findValue(node.next);
                newHead.random=findValue(node.random);
                newHead=newHead.next;
                node=node.next;
            }
            return oldToNewMap.get(head);
        }
        Node findValue(Node oldNode){
            if(oldNode==null){
                return null;
            }
            if(oldToNewMap.containsKey(oldNode)){
                return oldToNewMap.get(oldNode);
            }
            else{
                Node newNode=new Node(oldNode.val);
                oldToNewMap.put(oldNode,newNode);
                return newNode;
            }
        }
        public static void main(String[] args){
            CopyRandom copyRandom=new CopyRandom();
            Node node=new Node(7);
            node.next=new Node(13);
            node.next.next=new Node(11);
            node.next.next.next=new Node(10);
            node.next.next.next.next=new Node(1);
            node.random=null;
            node.next.random=node;
            node.next.next.random=node.next.next.next.next;
            node.next.next.next.random=node.next.next;
            node.next.next.next.next.random=node;
            copyRandom.copyRandomList(node);
        }
    }

