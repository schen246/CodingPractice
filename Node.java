import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    List<Node> neighbors = new ArrayList<>();
    public Node(int val) {
        this.val = val;
    }
}