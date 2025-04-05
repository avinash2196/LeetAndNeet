package LeetCode;

public class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null, next = null;
        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode root = head;
        ListNode kTail = null;//keep track of tail of last reversed nodes
        ListNode newHead = null; //new head of reversed K group
        int counter = 0;
        while (curr != null) {
            counter = 0;
            curr = root;
            while (counter < k && curr != null) {
                counter++;
                curr = curr.next;
            }
            if (counter == k) {
                ListNode revHead = this.reverseList(root, k);//head of reversed K Nodes
                if (newHead == null) newHead = revHead;
                if (kTail != null) kTail.next = revHead; //attach new reversed head to old tail
                kTail = root;
                root = curr;
            }
        }
        if (kTail != null) {
            kTail.next = root;
        }
        return newHead != null ? newHead : root;
    }
}
