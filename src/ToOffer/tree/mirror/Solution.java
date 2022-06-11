package ToOffer.tree.mirror;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp;
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree t = new Tree(new int[]{4,2,7,1,3,6,9});
        TreeNode newRoot = s.mirrorTree(t.root);
        Tree newTree = new Tree(newRoot);
        System.out.println(Arrays.toString(newTree.levelOrder()));
    }
}
