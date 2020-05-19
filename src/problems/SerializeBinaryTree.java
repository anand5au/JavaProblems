package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public static String serialize(TreeNode root) {
        final StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(final TreeNode root, final StringBuilder sb) {
        if(root == null) {
            sb.append("NL").append(",");
            return;
        }
        sb.append(root.data).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        final Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private static TreeNode deserialize(Queue<String> nodes) {
        final String val = nodes.remove();
        if(val.equals("NL")) {
            return null;
        }

        final TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BST();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 16);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        System.out.println("Original Tree Inorder: ");
        BinaryTree.printInOrder(tree.root);
        System.out.println();
        System.out.println("Deserialized Tree Inorder: ");
        BinaryTree.printInOrder(deserialize(serialize(tree.root)));
    }
}
