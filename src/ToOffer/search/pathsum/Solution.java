package ToOffer.search.pathsum;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Stack<StackElement> stack = new Stack<>();
        List<Integer> newList = new ArrayList<>();
        stack.push(new StackElement(root, 0, newList));
        while (!stack.isEmpty()) {
            StackElement e = stack.pop();
            int newSum = e.node.val + e.sum;
            //System.out.printf("node val: %d, sum: %d\n", e.node.val, newSum);
            if (e.node.left == null && e.node.right == null) {
                if (newSum == target) {
                    List<Integer> newPath = new ArrayList<>(e.path.size() + 1);
                    newPath.addAll(e.path);
                    newPath.add(e.node.val);
                    result.add(newPath);
                }
            } else {
                List<Integer> newPath = new ArrayList<>(e.path.size() + 1);
                newPath.addAll(e.path);
                newPath.add(e.node.val);
                System.out.println(newPath);
                if (e.node.left != null) {
                    //System.out.println("Add left");
                    stack.push(new StackElement(e.node.left, newSum, newPath));
                }
                if (e.node.right != null) {
                    //System.out.println("Add right");
                    stack.push(new StackElement(e.node.right, newSum, newPath));
                }
            }
        }
        return result;
    }

    private class StackElement {
        public TreeNode node;
        public int sum;
        public List<Integer> path;

        public StackElement(TreeNode node, int sum, List<Integer> path) {
            this.node = node;
            this.sum = sum;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1});
        Solution s = new Solution();
        List<List<Integer>> result = s.pathSum(t.root, 22);
        System.out.println(result);
    }
}
