public class MiddleoftheLinkedList {
    // two pointers
    public ListNode middleNode(ListNode head) {
        ListNode s = head, f = head;
        while (f != null) {
            if (f.next == null) {
                return s;
            }
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
}
