package LeetCode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode mergedList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mergedList = mergeTwoList(mergedList, lists[i]);
        }
        return mergedList;
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else {
            ListNode head = new ListNode();
            ListNode root = head;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    head.next = new ListNode(list2.val);
                    list2 = list2.next;
                    head = head.next;
                } else {
                    head.next = new ListNode(list1.val);
                    list1 = list1.next;
                    head = head.next;
                }
            }
            head.next = (list1 == null) ? list2 : list1;
            return root.next;
        }
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null && lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));
        // add head of each not null nodes list
        for (ListNode node : lists)
            if (node != null)
                queue.add(node);
        ListNode head = new ListNode();
        ListNode curr = head;
        //iterate over each node in queue , poll the first and then re-add next pointer if it exists
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null)
                queue.add(curr.next);
        }
        return head.next;
    }

}
