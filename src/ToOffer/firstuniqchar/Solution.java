package ToOffer.firstuniqchar;

public class Solution {
    public char firstUniqChar(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char result = s.firstUniqChar("abaccdeff");
        System.out.println(result);
    }
}
