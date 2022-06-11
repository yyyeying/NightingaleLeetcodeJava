package ToOffer.dualptr.reversewords;

public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        int start = -1;
        int end = -1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                if (start > 0 && end < 0){
                    end = i+1;
                    for (int j = end; j <= start; j++) {
                        result.append(s.charAt(j));
                    }
                    result.append(' ');
                    start = -1;
                    end = -1;
                }
            } else {
                if (start < 0){
                    start = i;
                }
                if (start>=0 && i == 0) {
                    end = 0;
                    for (int j = end; j <= start; j++) {
                        result.append(s.charAt(j));
                    }
                    result.append(' ');
                    start = -1;
                    end = -1;
                }
            }
        }
        if (result.length() > 1){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.reverseWords(" ");
        System.out.printf(result);
    }
}
