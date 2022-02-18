import java.util.HashMap;
import java.util.Map;

public class LRU {
    Node head, tail;
    int size;
    Map<Integer, Node> map;
    
    public LRU(int capacity) {
        this.size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        Node node = map.get(key);
        int res = node.val;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        return res;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) {
            map.get(key).val = value;
            get(key);
            return;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        if (map.size() > size) {
            Node cur = head.next;
            cur.next.prev = head;
            head.next = cur.next;
            map.remove(cur.key);
        }
    }
}

class Node {
    int key, val;
    Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}