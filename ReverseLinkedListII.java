public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode prev = d;
        
        int i = 1;
        while (i < m && head != null) {
            prev = head;
            head = head.next;
            i++;
        }
        ListNode preNode = prev;
        ListNode curNode = head;
        while (i <= n && head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            i++;
        }
        preNode.next = prev;
        curNode.next = head;
        return d.next;
    }
}
