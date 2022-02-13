public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);
        return reverse(merge(n1, n2));
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode d = new ListNode(-1);
        ListNode cur = d;
        int rem = 0;
        while (n1 != null || n2 != null || rem != 0) {
            if (n1 != null) {
                rem += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                rem += n2.val;
                n2 = n2.next;
            }
            cur.next = new ListNode(rem % 10);
            cur = cur.next;
            rem /= 10;
        }
        return d.next;
    }
}
