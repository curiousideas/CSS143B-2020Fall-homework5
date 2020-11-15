package Problem2;

import Problem1.TreeNode;

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode rootLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode rootRight = lowestCommonAncestor(root.right, p, q);

        if (rootLeft != null && rootRight != null) {
            return root;
        } else if (rootLeft != null && rootRight == null) {
            return rootLeft;
        } else {
            return rootRight;
        }
    }
}
