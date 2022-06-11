package ToOffer.search.kthlargest;

import datastructure.TreeNode;

public class Solution {
    int i, k, result;

    public int kthLargest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        this.i = 0;
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node.right);
        i++;
        if (i == k){
            result = node.val;
        }
        dfs(node.left);
    }
}
