package ToOffer.tree.levelorder;


import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Solution {
    public int[] levelOrder(TreeNode root) {
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
}
