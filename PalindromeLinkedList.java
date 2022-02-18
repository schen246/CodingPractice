public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode node = mid.next;
        mid.next = null;
        return compareTwo(head, reverse(node));
    }
    
    private ListNode findMid(ListNode head) {
        ListNode s = head, f = head;
        while (f != null) {
            if (f.next == null || f.next.next == null) {
                return s;
            }
            f = f.next.next;
            s = s.next;
        }
        return null;
    }
    
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newNode = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }
    
    private boolean compareTwo(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
