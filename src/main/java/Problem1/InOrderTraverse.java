package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            result.add((Integer) temp.val);
            cur = temp.right;
        }
        return result;
    }
}
