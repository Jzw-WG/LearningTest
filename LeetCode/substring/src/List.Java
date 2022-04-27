public class List {
    public static class ListNode {
        public int value;
        public ListNode next;
        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
    public boolean hasCross(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }
        ListNode ln1 = headA;
        ListNode ln2 = headB;
        int len1 = 0;
        int len2 = 0;
        while (ln1 != ln2) {
            if (ln1 == null) {
                ln1 = headB;
            } else {
                ln1 = ln1.next;
                len1++;
            }
            if (ln2 == nul) {
                ln2 = headA;
            } else {
                ln2 = ln2.next;
                len2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}