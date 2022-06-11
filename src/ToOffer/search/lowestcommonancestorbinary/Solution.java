package ToOffer.search.lowestcommonancestorbinary;

import datastructure.Tree;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        TreeNode result = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                result = path1.get(i);
            }
        }
        return result;
    }

    private void getPath(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null) {
            return;
        }
        path.add(node);
        // System.out.println(path);
        if (node == target) {
            return;
        }
        if (path.get(path.size() - 1) != target) {
            getPath(node.left, target, path);
        }
        if (path.get(path.size() - 1) != target) {
            getPath(node.right, target, path);
        }
        if (path.get(path.size() - 1) != target) {
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        Solution s = new Solution();
    }
}
