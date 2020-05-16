package problems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int[] range = new int[] {0, 0};
        getRange(root, range, 0);

        for (int i = range[0]; i <= range[1]; i++) {
            result.add(new ArrayList<>());
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, -range[0]));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int col = pair.getValue();

            result.get(col).add(node.data);
            if (node.left != null) {
                queue.add(new Pair(node.left, col-1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, col+1));
            }
        }
        return result;
    }

    private void getRange(TreeNode root, int[] range, int col) {
        if (root == null) {
            return;
        }
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);

        getRange(root.left, range, col - 1);
        getRange(root.right, range, col + 1);
    }
}
