package Easy;

/* 
    1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]
    Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
*/

public class One {

    public static void main(String[] args) {
        // case 1
        // int[] nums = {2,7,11,15};
        // int target = 9;
        // case 2
        int[] nums = {3,2,4};
        int target = 6;
        // case 3
        // int[] nums = {3,3};
        // int target = 6;
        twoSumWayOne(nums, target);
        twoSumWayTwo(nums, target);
    }

    private static int[] twoSumWayOne(int[] nums, int target){
        int[] result = new int[2];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = 0;
                sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        System.out.println("twoSumWayOne");
        System.out.println("result[0]:"+result[0]+",result[1]:"+result[1]);
        return result;
    }

    private static int[] twoSumWayTwo(int[] nums, int target) {
        int[] result = new int[2];
        int step = 1;
        int i = 0;
        while (i < nums.length) {
            if (step + i >= nums.length) {
                step++;
                i = 0;
                continue;
            } else if (nums[i] + nums[step + i] == target) {
                result[0] = i;
                result[1] = i + step;
                break;
            }
            i++;
        }
        System.out.println("twoSumWayTwo");
        System.out.println("result[0]:"+result[0]+",result[1]:"+result[1]);
        return result;
    }
}
