package ToOffer.divide.verifypostorder;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        int root = postorder[postorder.length - 1];
        int divide = 0;
        while (divide < postorder.length - 1) {
            if (postorder[divide] > root) {
                break;
            }
            divide++;
        }
        for (int i = divide; i < postorder.length - 1; i++) {
            if (postorder[i] <= root) {
                return false;
            }
        }
        int[] leftPostOrder = new int[divide];
        System.arraycopy(postorder, 0, leftPostOrder, 0, divide);
        int[] rightPostOrder = new int[postorder.length - divide - 1];
        if (postorder.length - divide - 1 >= 0)
            System.arraycopy(postorder, divide, rightPostOrder, 0, postorder.length - divide - 1);
        return verifyPostorder(leftPostOrder) && verifyPostorder(rightPostOrder);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.verifyPostorder(new int[]{1, 6, 2, 3, 5}));
        System.out.println(s.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
