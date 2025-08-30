package HundredQuestions;

import java.util.LinkedList;

import java.util.List;

public class addtoArrayForm {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = num.length - 1; // pointer on num's least-significant digit
        int carry = 0;

        while (i >= 0 || k > 0) {
            int digitNum = (i >= 0) ? num[i] : 0; // 0 if we've run past the left edge
            int digitK = k % 10; // current least-significant digit of k

            int sum = digitNum + digitK + carry;
            result.addFirst(sum % 10); // store the unit digit
            carry = sum / 10; // propagate carry

            k /= 10; // drop the digit we just processed
            i--; // move left in num
        }

        if (carry > 0) { // leftover carry becomes new MSB
            result.addFirst(carry);
        }
        return result; // List<Integer> in left-to-right order
    }

    public static void main(String[] args) {
        addtoArrayForm l = new addtoArrayForm();
        int[] num1 = { 1, 2, 0, 0 };
        System.out.println(l.addToArrayForm(num1, 34)); // [1, 2, 3, 4]

        int[] num2 = { 2, 7, 4 };
        System.out.println(l.addToArrayForm(num2, 181)); // [4, 5, 5]

        int[] num3 = { 2, 1, 5 };
        System.out.println(l.addToArrayForm(num3, 806)); // [1, 0, 2, 1]
    }
}
