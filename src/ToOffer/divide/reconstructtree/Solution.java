package ToOffer.divide.reconstructtree;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        // System.out.printf("preorder: %s, inorder: %s\n", Arrays.toString(preorder), Arrays.toString(inorder));
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        while (rootIndex < inorder.length && inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        // System.out.printf("rootIndex: %d\n", rootIndex);
        if (rootIndex > 0) {
            int[] leftInOrder = new int[rootIndex];
            int[] leftPreOrder = new int[rootIndex];
            System.arraycopy(inorder, 0, leftInOrder, 0, rootIndex);
            int j = 0;
            for (int k : preorder) {
                boolean found = false;
                for (int m :
                        leftInOrder) {
                    if (k == m) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    leftPreOrder[j] = k;
                    j++;
                }
            }
            root.left = buildTree(leftPreOrder, leftInOrder);
        }
        int rightLength = inorder.length - rootIndex - 1;
        if (rightLength > 0) {
            int[] rightPreOrder = new int[rightLength];
            int[] rightInOrder = new int[rightLength];
            for (int i = 0; i < rightLength; i++) {
                rightInOrder[i] = inorder[i + rootIndex + 1];
            }
            int j = 0;
            for (int k : preorder) {
                boolean found = false;
                for (int m :
                        rightInOrder) {
                    if (k == m) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    rightPreOrder[j] = k;
                    j++;
                }
            }
            root.right = buildTree(rightPreOrder, rightInOrder);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree t = new Tree(s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        int[] result = t.levelOrder();
        System.out.println(Arrays.toString(result));
    }
}
