package HundredQuestions;

import java.util.Arrays;

public class TwosumII {
    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int arr[] = { 12, 23, 35, 45, 56, 67 };
        int target = 80;

        int result[] = twoSum(arr, target);
        System.out.println(" " + Arrays.toString(result));
    }
}
