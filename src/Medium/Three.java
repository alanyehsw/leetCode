package Medium;

import java.util.List;

/*
    3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest 
    substring
    without repeating characters.

    Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

    Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

    Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    
    Example 4:
        Input: s = " "
        Output: 1
    
    Example 5:
        Input: s = ""
        Output: 0

    Example 6:
        Input: s = "c"
        Output: 1

    Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
*/

public class Three {
    // TODO:未完成
    public static void main (String[] args) {
        // case 1
        // String s = "abcabcbb";
        // case 2
        // String s = "bbbbb";
        // case 3
        // String s = "pwwkew";
        // case 4
        // String s = " ";
        // case 5
        // String s = "";
        // case 6
        // String s = "c";
        // case 7
        // String s = "aab";
        // case 8
        // String s = "dvdf";
        // ans : 3
        // case 9
        // String s = "jbpnbwwd";
        // ans : 4
        // case 10
        String s = "ggububgvfk";
        // ans : 6
        /*String[] listStr = {"abcabcbb","bbbbb","pwwkew"," ","","c","aab","dvdf","jbpnbwwd","ggububgvfk"};
        for (String s : listStr) {
            System.out.println("s : " + s);
            System.out.println("lengthOfLongestSubstring(s) : " + lengthOfLongestSubstring(s));
        }*/
        System.out.println("lengthOfLongestSubstring(s) : " + lengthOfLongestSubstring(s));

    }

    private static int lengthOfLongestSubstring(String s) {
        // 比對每個char沒有重複就組成字串
        int alreadyCheckCharLen = 0;
        StringBuffer combinationSB = new StringBuffer();
        String mostLongestString = "";
        while (alreadyCheckCharLen < s.length()) {
            int repeatCharPosition = combinationSB.indexOf(String.valueOf(s.charAt(alreadyCheckCharLen)));

            if (repeatCharPosition < 0) {
                // combinationSB 沒有 match 所以將該字元加入
                combinationSB.append(s.charAt(alreadyCheckCharLen));

                alreadyCheckCharLen++;
                if (alreadyCheckCharLen == s.length()) {
                    if (mostLongestString.length() < combinationSB.toString().length()) {
                        return combinationSB.toString().length();
                    } else {
                        return mostLongestString.length();
                    }
                }
            } else {
                if (mostLongestString.length() == 0) {
                    // 代表 mostLongestString 還沒有值就不需比較。
                    mostLongestString = combinationSB.toString();
                } else if (mostLongestString.length() <= combinationSB.toString().length()) {
                    // 如果 combinationSB 內字元長度大於 mostLongestString，則將 mostLongestString 宣告為該 combinationSB
                    mostLongestString = combinationSB.toString();
                }

                // 使用完畢，初始化 combinationSB
                combinationSB.setLength(0);

                if (mostLongestString.length() != 1) {
                    // 找到 mostLongestString 重複的那個字元
                    int repeatMostLongestStringPos = mostLongestString.indexOf(String.valueOf(s.charAt(alreadyCheckCharLen)));
    
                    // mostLongestString 縮減為該重複值的位置到該自傳的最後
                    combinationSB.append(mostLongestString.substring(repeatMostLongestStringPos + 1, mostLongestString.length()));
                }
            }
        }
        if (mostLongestString.length() == 0) {
            return combinationSB.toString().length();
        }
        return mostLongestString.length();
    }
}
