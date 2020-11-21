class ListMergeSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);
        // return mergeTwoSortedList(left, right);
        return mergeTwoSortedList(sortedLeft, sortedRight);
    }

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode(0);
        ListNode res = sentinal;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                sentinal.next = temp1;
                temp1 = temp1.next;
            } else {
                sentinal.next = temp2;
                temp2 = temp2.next;
            }
            sentinal = sentinal.next;            
        }
        if (temp1 != null) {
            sentinal.next = temp1;
        } else if (temp2 != null) {
            sentinal.next = temp2;
        }
        return res.next;
    }

    public ListNode findMid(ListNode l) {
        ListNode fast = l;
        ListNode slow = l;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListMergeSort.ListNode listNode = new ListMergeSort.ListNode(4);
        listNode.next = new ListMergeSort.ListNode(2);
        listNode.next.next = new ListMergeSort.ListNode(1);
        listNode.next.next.next = new ListMergeSort.ListNode(3);
        ListMergeSort l = new ListMergeSort();
        ListNode res = l.sortList(listNode);
        System.out.println(res);
    }
}