package ToOffer.tree.issub;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            System.out.println("B == null");
            return false;
        }
        if (A == null) {
            System.out.println("A == null");
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // System.out.println("node.val = " + node.val + ", b.val = " + B.val);
            if (node.val == B.val) {
                if (compare(node, B)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private boolean compare(TreeNode a, TreeNode b) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.add(a);
        queueB.add(b);
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            TreeNode nodeA = queueA.poll();
            TreeNode nodeB = queueB.poll();
            // System.out.println("a.val = " + nodeA.val + ", b.val = " + nodeB.val);
            assert nodeB != null;
            if (nodeA.val != nodeB.val) {
                return false;
            }
            if (nodeA.left != null && nodeB.left != null) {
                queueA.add(nodeA.left);
                queueB.add(nodeB.left);
            } else if (nodeA.left == null && nodeB.left != null) {
                return false;
            }

            if (nodeA.right != null && nodeB.right != null) {
                queueB.add(nodeB.right);
                queueA.add(nodeA.right);
            } else if (nodeA.right == null && nodeB.right != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Tree a = new Tree(new int[]{1,2,3});
        Tree b = new Tree(new int[]{3, 1});
        boolean result = s.isSubStructure(a.root, b.root);
        System.out.println(result);
    }
}
