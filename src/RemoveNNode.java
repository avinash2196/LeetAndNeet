class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


public class RemoveNNode {
       public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead=new ListNode();
            newHead.next=head;
            ListNode first=newHead;
            ListNode second=newHead;
            for(int i=1;i<=n+1;i++){
                first=first.next;
            }
            while(first!=null){
                first=first.next;
                second=second.next;
            }
            second.next=second.next.next;
            return newHead.next;
        }

        public static void main(String[] args){
           ListNode head=new ListNode(1);
          /* head.next=new ListNode(2);
           head.next.next=new ListNode(3);
           head.next.next.next=new ListNode(4);
           head.next.next.next.next=new ListNode(5);*/
           RemoveNNode removeNNode=new RemoveNNode();
           removeNNode.removeNthFromEnd(head,1);
        }
}
