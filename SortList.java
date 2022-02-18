public class SortList {
    // merge sort - time: O(nlogn) space: O(logn)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode node = mid.next;
        mid.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(node);
        return mergeTwo(leftNode, rightNode);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode s = head, f = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
    
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(-1);
        ListNode cur = d;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return d.next;
    }
}
