package Easy;

import java.util.Arrays;

/*
    1725. Number Of Rectangles That Can Form The Largest Square

    You are given an array rectangles where rectangles[i] = [li, wi] represents the ith rectangle of length li and width wi.
    You can cut the ith rectangle to form a square with a side length of k if both k <= li and k <= wi.
    For example,if you have a rectangle [4,6], you can cut it to get a square with a side length of at most 4.
    Let maxLen be the side length of the largest square you can obtain from any of the given rectangles.
    Return the number of rectangles that can make a square with a side length of maxLen.

    Example 1:
        Input: rectangles = [[5,8],[3,9],[5,12],[16,5]]
        Output: 3
        Explanation: The largest squares you can get from each rectangle are of lengths [5,3,5,5].
        The largest possible square is of length 5, and you can get it out of 3 rectangles.

    Example 2:
        Input: rectangles = [[2,3],[3,7],[4,3],[3,7]]
        Output: 3

    Constraints:
        1 <= rectangles.length <= 1000
        rectangles[i].length == 2
        1 <= li, wi <= 109
        li != wi
*/

public class OneSevenTwoFive {
    public static void main (String[] args) {
        int[][] question1 = {{5,8},{3,9},{5,12},{16,5}};
        System.out.println("question2 : " + countGoodRectangles2(question1));

        int[][] question2 = {{2,3},{3,7},{4,3},{3,7}};
        System.out.println("question2 : " + countGoodRectangles2(question2));
    }

    public static int countGoodRectangles(int[][] rectangles) {
        int goodRect = 0;

        int[] smallestSquareSide = new int[rectangles.length];
        for (int index = 0; index < rectangles.length; index++) {
            smallestSquareSide[index] = Math.min(rectangles[index][0], rectangles[index][1]);
        }

        Arrays.sort(smallestSquareSide);

        for (int index = smallestSquareSide.length-1 ; index > -1 ; index--) {
            if (smallestSquareSide[index] == smallestSquareSide[smallestSquareSide.length-1]) {
                goodRect++;
            } else {
                break;
            }
        }

        return goodRect;
    }

    public static int countGoodRectangles2(int[][] rectangles) {
        int minSide;
        int counter = 0;
        int maxLen = 0;
        for(int i = 0; i < rectangles.length; i++) {
            minSide = Math.min(rectangles[i][0], rectangles[i][1]);
            if(minSide > maxLen) {
                counter = 1;
                maxLen = minSide;
            } else if (minSide == maxLen) {
                counter++;
            }
        }
        return counter;
    }
}
