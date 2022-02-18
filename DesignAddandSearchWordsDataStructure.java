import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure {
    Node root;
    
    /** Initialize your data structure here. */
    public DesignAddandSearchWordsDataStructure() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }
    
    private boolean dfs(char[] arr, int index, Node node) {
        if (index == arr.length) {
            return node.isWord;
        }
        if (arr[index] == '.') {
            for (Node nei : node.children.values()) {
                if (dfs(arr, index + 1, nei)) {
                    return true;
                }
            }
            return false;
        }
        if (!node.children.containsKey(arr[index])) {
            return false;
        }
        return dfs(arr, index + 1, node.children.get(arr[index]));
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