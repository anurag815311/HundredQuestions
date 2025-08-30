/*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n). */

package HundredQuestions;

public class fibonacciNumber {
    public static int lastTermOfSeries(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int firstNumber = 0;
        int secondNumber = 1;
        int thirdNumber;
        for (int i = 0; i < n; i++) {
            thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
        }
        return firstNumber;
    }

    public static void main(String[] args) {
        int lastTerm = lastTermOfSeries(10);
        System.out.println(" " + lastTerm);
    }
}
