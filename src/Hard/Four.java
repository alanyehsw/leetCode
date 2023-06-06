package Hard;

import java.util.Arrays;

/*
    4. Median of Two Sorted Arrays
    Given two sorted arrays nums1 and nums2 of size m and n respectively,
    return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).

    Example 1:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

    Constraints:
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
*/
public class Four {
    public static void main (String[] args) {
        int[] quest11 = {1,3};
        int[] quest12 = {2};
        System.out.println("question1 findMedianSortedArrays : " + findMedianSortedArrays(quest11, quest12));

        int[] quest21 = {1,2};
        int[] quest22 = {3,4};
        System.out.println("question2 findMedianSortedArrays : " + findMedianSortedArrays(quest21, quest22));

        int[] quest31 = {1,3};
        int[] quest32 = {2,7};
        System.out.println("question3 findMedianSortedArrays : " + findMedianSortedArrays(quest31, quest32));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeNums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,mergeNums,0,nums1.length);
        System.arraycopy(nums2, 0, mergeNums, nums1.length, nums2.length);

        Arrays.sort(mergeNums);
        if (mergeNums.length % 2 == 0) {
            // 長度偶數
            System.out.println("長度偶數");
            System.out.println("mergeNums[mergeNums.length/2 - 1] : " + mergeNums[mergeNums.length/2 - 1]);
            System.out.println("mergeNums[mergeNums.length/2] : " + mergeNums[mergeNums.length/2]);
            return (double)(mergeNums[mergeNums.length/2 - 1] + mergeNums[mergeNums.length/2])/2;
        } else {
            // 長度奇數
            // System.out.println("長度奇數");
            return (double)mergeNums[mergeNums.length/2];
        }
    }
}
