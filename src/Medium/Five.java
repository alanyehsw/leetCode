package Medium;

/*
    5. Longest Palindromic Substring

    Given a string s, return the longest palindromic substring in s.

    Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

    Example 2:
        Input: s = "cbbd"
        Output: "bb"

    Constraints:
        1 <= s.length <= 1000
        s consist of only digits and English letters.
*/
public class Five {
    public static void main (String[] args) {
        String quest1 = "babad";
        System.out.println("quest1 longestPalindrome : " + longestPalindrome(quest1));

        String quest2 = "cbbd";
        System.out.println("quest2 longestPalindrome : " + longestPalindrome(quest2));

        String quest3 = "ac";
        System.out.println("quest3 longestPalindrome : " + longestPalindrome(quest3));

        // aca
        String quest4 = "aacabdkacaa";
        System.out.println("quest4 longestPalindrome : " + longestPalindrome(quest4));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int sIndex = 0 ; sIndex < s.length(); sIndex++) {
            char charS = s.charAt(sIndex);
            int left = sIndex;
            int right = sIndex;
            System.out.println("s.charAt(" + sIndex + ") : " + charS);

            while (left >= 0 && s.charAt(left) == charS) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == charS) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                System.out.println("s.charAt(" + left + ") : " + s.charAt(left));
                System.out.println("s.charAt(" + right + ") : " + s.charAt(right));
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            System.out.println("right : " + right);
            System.out.println("left : " + left);

            System.out.println("right - left : " + (right - left));
            System.out.println("end - start : " + (end - start));
            left += 1;
            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end);
    }
}
