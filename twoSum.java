//package HundredQuestions;

import java.util.Arrays;

public class twoSum {
    public static int[] indexReturned(int[] arr, int target) {
        int ans[] = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 6, 6, 4 };
        int answer[] = indexReturned(arr, 12);
        System.out.println(Arrays.toString(answer));
    }
}
