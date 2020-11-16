package ExtraCredit;

import Problem1.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143886/Java-O(1)-space-excluding-recursive-stack-space
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143798/1ms-beat-100-simple-Java-dfs-with(without)-hashmap-including-explanation
// Really helpful guides

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        List<Integer> result = new ArrayList();
        findTar(root, target, k, result);
        return result;
    }

    public static int findTar(TreeNode<Integer> root, TreeNode<Integer> target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        } else if (root == target) {
            findNode(root, k, result);
            return 1;
        }

        int left = findTar(root.left, target, k, result);
        int right = findTar(root.right, target, k, result);

        if (left == k || right == k) {
            findNode(root, 0, result);
        } else if (right != -1) {
            findNode(root.left, k - right - 1, result);
            return right + 1;
        } else if (left != -1) {
            findNode(root.right, k - left - 1, result);
            return left + 1;
        }

        return -1;
    }

    public static void findNode(TreeNode<Integer> root, int k, List<Integer> result) {
        if (root == null) {
            return;
        } else if (k == 0) {
            result.add(root.val);
            return;
        }
        findNode(root.left, k - 1, result);
        findNode(root.right, k - 1, result);
    }
}
