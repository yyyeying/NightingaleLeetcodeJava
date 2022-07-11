package ToOffer.simulation.validatestacksequence;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int push_ptr = 0;
        int pop_ptr = 0;
        while (push_ptr < pushed.length || pop_ptr < popped.length) {
            if (push_ptr == pushed.length && popped[pop_ptr] != stack.peek()) {
                //System.out.printf("Failed.\n");
                return false;
            }
            if (!stack.isEmpty() && stack.peek() == popped[pop_ptr]) {
                //System.out.printf("pop %d, pop_ptr = %d, push_ptr = %d\n", stack.peek(), pop_ptr, push_ptr);
                stack.pop();
                pop_ptr++;
            } else {
                stack.push(pushed[push_ptr++]);
                //System.out.printf("push %d, pop_ptr = %d, push_ptr = %d\n", stack.peek(), pop_ptr, push_ptr);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
        System.out.println(result);
    }
}
