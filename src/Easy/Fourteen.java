package Easy;

import java.util.Arrays;

/*
    14.Longest Common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    
    Constraints:
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
*/
public class Fourteen {
    public static void main (String[] args) {
        // case 1
        // String[] strs = {"flower","flow","flight"};
        // case 2
        // String[] strs = {"dog","racecar","car"};
        // case 3
        String[] strs = {"aaa","aa","aaa"};

        System.out.println("longestCommonPrefix(strs) : " + longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length-1];
        int index = 0;
        while (index < firstStr.length() && index < lastStr.length()) {
            if (firstStr.charAt(index) == lastStr.charAt(index)) {
                index ++;
            } else {
                break;
            }
        }

        return firstStr.substring(0, index);
    }
}
