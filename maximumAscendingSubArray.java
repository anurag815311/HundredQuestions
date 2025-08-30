package HundredQuestions;

public class maximumAscendingSubArray {
    public static int maximunSum(int[] arr) {
        int maxSum = arr[0];
        int curSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                curSum = curSum + arr[i];
            } else {
                maxSum = Math.max(maxSum, curSum);
                curSum = arr[i];
            }
        }
        maxSum = Math.max(maxSum, curSum);

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 5, 50, 55 };
        int result = maximunSum(arr);
        System.out.println(" " + result);
    }
}
