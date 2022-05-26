package ToOffer.treeissymmetric;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            assert right != null;
            if (left.val != right.val){
                return false;
            }
            if (left.left != null && right.right != null){
                leftQueue.add(left.left);
                rightQueue.add(right.right);
            } else if (left.left != null || right.right != null){
                return false;
            }
            if (left.right != null && right.left != null){
                leftQueue.add(left.right);
                rightQueue.add(right.left);
            } else if (left.right != null || right.left != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree t = new Tree(new int[]{1,2,2,-1,3,-1,3});
        boolean result = s.isSymmetric(t.root);
        System.out.println(result);
    }
}
