//package HundredQuestions;

public class meanOfSortedArrays {
    public int[] merge(int arr1[], int arr2[]) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int arr3[] = new int[arr1.length + arr2.length];
        while (p1 != arr1.length || p2 != arr2.length) {
            int val1 = p1 < arr1.length ? arr1[p1] : Integer.MAX_VALUE;
            int val2 = p2 < arr2.length ? arr2[p2] : Integer.MAX_VALUE;
            if (val1 < val2) {
                arr3[p3] = val1;
                p1++;
            } else {
                arr3[p3] = val2;
                p2++;
            }
            p3++;
        }
        return arr3;
    }

    public double mean(int arr1[], int arr2[]) {
        int merged_arr[] = merge(arr1, arr2);
        long sum = 0;
        for (int i = 0; i < merged_arr.length - 1; i++) {
            sum = sum + merged_arr[i];
        }
        double avg = sum / merged_arr.length;
        return avg;
    }

    public static void main(String[] args) {
        meanOfSortedArrays M = new meanOfSortedArrays();
        int num1[] = { 12, 24, 56, 78, 98, 100 };
        int num2[] = { 34, 44, 55, 66, 77, 99, 111 };
        double Mean_of_sorted_Array = M.mean(num1, num2);
        System.out.println(" " + Mean_of_sorted_Array);
    }
}

/*
 * NO MERGE REQUIRED FOR SOLUTION ---->
 * public double mean(int[] arr1, int[] arr2) {
 * long sum = 0;
 * for (int v : arr1) sum += v;
 * for (int v : arr2) sum += v;
 * int totalLength = arr1.length + arr2.length;
 * return (double) sum / totalLength;
 * }
 * 
 */