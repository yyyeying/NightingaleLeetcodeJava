package datastructure;

import java.util.*;
import java.util.List;

public class Tree {
    public TreeNode root;

    public Tree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                continue;
            }
            if (i == 0) {
                root = new TreeNode(array[i]);
                continue;
            }
            boolean flag = false;
            TreeNode ptr = root;
            for (int j = 0; j < 32; j++) {
                int path = ((i + 1) >> (31 - j)) & 1;
                if (!flag && path == 1) {
                    flag = true;
                    continue;
                }
                if (flag && path == 0 && j < 31) {
                    ptr = ptr.left;
                } else if (flag && path == 1 && j < 31) {
                    ptr = ptr.right;
                } else if (flag && path == 0 && j == 31) {
                    ptr.left = new TreeNode(array[i]);
                } else if (flag && path == 1 && j == 31) {
                    ptr.right = new TreeNode(array[i]);
                }
            }
        }
    }

    public int[] levelOrder() {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        treeQueue.add(root);
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            result.add(node.val);
            if (node.left != null) {
                treeQueue.add(node.left);
            }
            if (node.right != null) {
                treeQueue.add(node.right);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Tree t = new Tree(new int[]{3, 9, 20, -1, -1, 15, 7});
        int[] levelOrder = t.levelOrder();
        System.out.println(Arrays.toString(levelOrder));
    }
}
