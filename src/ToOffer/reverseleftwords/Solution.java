package ToOffer.reverseleftwords;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        String result = new String();
        for (int i = n; i<s.length(); i++){
            result += s.charAt(i);
        }
        for (int i = 0; i<n;i++){
            result += s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.reverseLeftWords("abcdefg", 2);
        System.out.println(result);
    }
}
