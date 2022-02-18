public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLen(headA);
        int lenB = findLen(headB);
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int findLen(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
