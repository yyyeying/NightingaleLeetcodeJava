package exercise.tree.maximumdepth;

import datastructure.TreeNode;

import java.util.Stack;

class StackElement {
    public TreeNode node;
    public int depth;

    public StackElement(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Stack<StackElement> stack = new Stack<>();
        stack.push(new StackElement(root, 1));
        while (!stack.empty()) {
            StackElement currentElement = stack.pop();
            int pushedNodes = 0;
            if (currentElement.node.left != null) {
                stack.push(new StackElement(currentElement.node.left, currentElement.depth + 1));
                pushedNodes++;
            }
            if (currentElement.node.right != null) {
                stack.push(new StackElement(currentElement.node.right, currentElement.depth + 1));
                pushedNodes++;
            }
            if (pushedNodes == 0 && currentElement.depth > maxDepth) {
                maxDepth = currentElement.depth;
            }
        }
        return maxDepth;
    }

    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

}
