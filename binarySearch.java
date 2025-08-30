package HundredQuestions;

public class binarySearch {
    public static int binarySearching(int arr[], int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 23, 34, 45, 56, 67, 78, 89, 90, 909 };
        int target = 56;
        int result = binarySearching(arr, target);
        System.out.println(" " + result);
    }
}
