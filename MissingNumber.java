/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums. */

//package HundredQuestions;

public class MissingNumber {
    public int missingNumber(int[] arr) {
        int expectedSum = 0;
        int originalSum = 0;
        int l = arr.length;
        for (int n : arr) {
            originalSum = originalSum + n;
        }
        for (int i = 0; i < l + 1; i++) {
            expectedSum = expectedSum + i;

        }

        return expectedSum - originalSum;
    }

    public static void main(String[] args) {
        MissingNumber M = new MissingNumber();
        int[] arr1 = { 1, 2, 3, 4, 0, 6 };
        int Missing_Number = M.missingNumber(arr1);

        System.out.println(" " + Missing_Number);
    }
}
