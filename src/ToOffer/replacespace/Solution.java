package ToOffer.replacespace;

public class Solution {
    public String replaceSpace(String s) {
        String result = new String();
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == ' '){
                result += "%20";
            }
            else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.replaceSpace("a v s");
        System.out.println(result);
    }
}
