import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, map, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int pL, int pR, Map<Integer, Integer> map, int[] inorder, int iL, int iR) {
        if (pL > pR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pL]);
        int len = map.get(preorder[pL]) - iL;
        root.left = helper(preorder, pL + 1, pL + len, map, inorder, iL, iL + len - 1);
        root.right = helper(preorder, pL + len + 1, pR, map, inorder, iL + len + 1, iR);
        return root;
    }
}
