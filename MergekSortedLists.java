import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    // k way merge - time: O(n * k * logk) space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode d = new ListNode(-1);
        ListNode cur = d;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur = cur.next;
        }
        return d.next;
    }

    // 2 way merge - time: O(k * logk * n) space: O(logk)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeK(lists, 0, lists.length - 1);
    }

    private ListNode mergeK(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode nodeLeft = mergeK(lists, left, mid);
        ListNode nodeRight = mergeK(lists, mid + 1, right);
        return mergeTwo(nodeLeft, nodeRight);
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
