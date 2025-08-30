package HundredQuestions;

public class medianOfSortedArrays {
    public static double medianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return medianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1; // move left
            } else {
                low = partitionX + 1; // move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        int arr1[] = { 12, 32, 34, 45 };
        int arr2[] = { 12, 24, 45, 56 };
        double Median = medianSortedArrays(arr1, arr2);
        System.out.println(" " + Median);

    }
}

/*
 * Alternate Solution ----->>>
 * class Solution {
 * public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 * int[] ans = merge(nums1 , nums2);
 * 
 * if(ans.length %2 ==0 ){
 * 
 * double ans2 = (double)(ans[ans.length/2] + ans[ans.length/2 -1 ])/2;
 * return ans2 ;
 * }else{
 * double ans2 = (double) ( ans[ans.length/2]);
 * 
 * return ans2 ;
 * }
 * }
 * 
 * public int[] merge(int[] arr1 , int[] arr2 ){
 * 
 * int[] ans = new int[arr1.length + arr2.length];
 * 
 * int p1 = 0 ;
 * int p2 = 0 ;
 * int p3 = 0 ;
 * 
 * while(p1<arr1.length || p2<arr2.length){
 * 
 * int val1 = p1<arr1.length ? arr1[p1] : Integer.MAX_VALUE;
 * int val2 = p2<arr2.length ? arr2[p2] : Integer.MAX_VALUE ;
 * 
 * if(val1<val2){
 * ans[p3] = val1 ;
 * p1++;
 * }else{
 * ans[p3] = val2 ;
 * p2++;
 * }
 * p3++;
 * }
 * return ans ;
 * }
 * }
 */