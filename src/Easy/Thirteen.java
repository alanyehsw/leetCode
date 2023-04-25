package Easy;

import java.util.HashMap;
import java.util.Map;

/*
    13. Roman to Integer
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example,
    2 is written as II in Roman numeral,just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.
    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    Example 1:
        Input: s = "III"
        Output: 3
        Explanation: III = 3.
    Example 2:
        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.
    Example 3:
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
        1 <= s.length <= 15
        s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
        It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/
public class Thirteen {
    public static void main(String[] args) {
        // case 1
        // String s = "III";
        // case 2
        // String s = "LVIII";
        // case 3
        String s = "MCMXCIV";
        // System.out.println(s + " : " + romanToInt(s));
        // System.out.println(s + " : " + romanToIntWay2(s));
        System.out.println(s + " : " + romanToIntWay3(s));
    }

    /*
     * soln 1.
     * 4(IV) 9(IX) 40(XL) 90(XC) 400(CD) 900(CM) 特殊數字
    */
    private static int romanToInt(String s) {
        int intS = 0;

        // 初始化羅馬數字對應的值
        char[] romanNumeral = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] romanNumeralValue = {1, 5, 10, 50, 100, 500, 1000};

        // 判斷是否為特殊羅馬數字
        for (int sNo = 0; sNo <= s.length()-1; sNo++) {

            // 確認羅馬數字在陣列哪個位置
            int romanNumIndex = 0;
            for (int i = 0; i <= romanNumeral.length-1; i++) {
                if (romanNumeral[i] == s.charAt(sNo)) {
                    romanNumIndex = i;
                    break;
                }
            }

            if (sNo == s.length()-1) {
                // 最後一位就不用判斷後一個羅馬數字
                intS += romanNumeralValue[romanNumIndex];
            } else {
                int sNextNo = sNo+1;
                switch (s.charAt(sNo)) {
                    case 'I':
                        if (s.charAt(sNextNo) == 'V') {
                            intS += 4;
                            sNo ++;
                            break;
                        }
                        if (s.charAt(sNextNo) == 'X') {
                            intS += 9;
                            sNo ++;
                            break;
                        }
                        intS += romanNumeralValue[romanNumIndex];
                        break;
                    case 'X':
                        if (s.charAt(sNextNo) == 'L') {
                            intS += 40;
                            sNo ++;
                            break;
                        }
                        if (s.charAt(sNextNo) == 'C') {
                            intS += 90;
                            sNo ++;
                            break;
                        }
                        intS += romanNumeralValue[romanNumIndex];
                        break;
                    case 'C':
                        if (s.charAt(sNextNo) == 'D') {
                            intS += 400;
                            sNo ++;
                            break;
                        }
                        if (s.charAt(sNextNo) == 'M') {
                            intS += 900;
                            sNo ++;
                            break;
                        }
                        intS += romanNumeralValue[romanNumIndex];
                        break;
                    default:
                        intS += romanNumeralValue[romanNumIndex];
                        break;
                }
            }
        }
        return intS;
    }

    private static int romanToIntWay2 (String s) {
        int sum = 0;

        Map<String, Integer> romanNumeral = new HashMap<>();
        romanNumeral.put("I", 1);
        romanNumeral.put("V", 5);
        romanNumeral.put("X", 10);
        romanNumeral.put("L", 50);
        romanNumeral.put("C", 100);
        romanNumeral.put("D", 500);
        romanNumeral.put("M", 1000);
        romanNumeral.put("IV", 4);
        romanNumeral.put("IX", 9);
        romanNumeral.put("XL", 40);
        romanNumeral.put("XC", 90);
        romanNumeral.put("CD", 400);
        romanNumeral.put("CM", 900);

        while (s.length() >= 1) {
            // System.out.println("s.length() : " + s.length());
            
            if (s.length() >= 2) {
                if (romanNumeral.get(s.substring(0, 2)) != null) {
                    // System.out.println("s.substring(0, 2) : " + s.substring(0, 2));
                    sum += romanNumeral.get(s.substring(0, 2));
                    s = s.substring(2, s.length());
                    continue;
                }
            }
            if (romanNumeral.get(s.substring(0, 1)) != null) {
                // System.out.println("s.substring(0, 1) : " + s.substring(0, 1));
                sum += romanNumeral.get(s.substring(0, 1));
                s = s.substring(1, s.length());
            }
        }

        return sum;
    }

    private static int romanToIntWay3 (String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
