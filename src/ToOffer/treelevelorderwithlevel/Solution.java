package ToOffer.treelevelorderwithlevel;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.*;

public class Solution {
    static class StackElement {
        TreeNode node;
        int level;

        StackElement(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<StackElement> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(new StackElement(root, 0));
        while (!queue.isEmpty()) {
            StackElement e = queue.poll();
            if (result.size() < e.level + 1) {
                result.add(new ArrayList<>());
            }
            result.get(e.level).add(e.node.val);
            if (e.node.left != null) {
                queue.add(new StackElement(e.node.left, e.level + 1));
            }
            if (e.node.right != null) {
                queue.add(new StackElement(e.node.right, e.level + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Tree t = new Tree(new int[]{3, 9, 20, -1, -1, 15, 7});
        Solution s = new Solution();
        List<List<Integer>> result = s.levelOrder(t.root);
        System.out.println(result.toString());
    }
}
