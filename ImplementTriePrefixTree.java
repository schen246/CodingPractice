import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    Node root;
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.children.get(ch) == null) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children.get(ch) == null) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }
}

class Node {
    boolean isWord;
    Map<Character, Node> children;
    public Node() {
        isWord = false;
        children = new HashMap<>();
    }
}