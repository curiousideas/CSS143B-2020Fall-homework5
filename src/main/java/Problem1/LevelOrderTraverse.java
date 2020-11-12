package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// I used a LinkedList to implement my queue. I used it because I'm familiar with it.

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                level.add((Integer) temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
