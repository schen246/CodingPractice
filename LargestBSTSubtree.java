public class LargestBSTSubtree {
    // recursion - time: O(n) space: O(height)
    public int largestBSTSubtree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    
    // int[]: cnt nodes {-1: not BST, others: BST and cnt nodes} , min val, max val
    private int[] helper(TreeNode root, int[] res) {
        if (root == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left, res);
        int[] right = helper(root.right, res);
        int[] ans = new int[3];
        if (left[0] != -1 && right[0] != -1 && left[2] < root.val && root.val < right[1]) {
            ans[0] = left[0] + right[0] + 1;
            ans[1] = Math.min(left[1], root.val);
            ans[2] = Math.max(right[2], root.val);
            res[0] = Math.max(res[0], ans[0]);
        } else {
            ans[0] = -1;
        }
        return ans;
    }

    // recursion + wrapper class
    public int largestBSTSubtree2(TreeNode root) {
        int[] res = new int[1];
        helper2(root, res);
        return res[0];
    }
    
    private Node helper2(TreeNode root, int[] res) {
        if (root == null) {
            return new Node(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = helper2(root.left, res);
        Node right = helper2(root.right, res);
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            res[0] = Math.max(res[0], left.cnt + right.cnt + 1);
            return new Node(true, left.cnt + right.cnt + 1, Math.min(left.min, root.val), Math.max(root.val, right.max));
        }
        return new Node(false, 0, 0, 0);
    }

    class Node {
        boolean isBST;
        int cnt;
        long min, max;
        public Node(boolean isBST, int cnt, long min, long max) {
            this.isBST = isBST;
            this.cnt = cnt;
            this.min = min;
            this.max = max;
        }
    }
}
