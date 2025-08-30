package HundredQuestions;

import java.util.Scanner;

public class sumofdigit {

    public void digitSum(int n) {
        if (n < 0) {
            return;
        }
        int sum = 0;
        int rem;
        while (n > 0) {
            rem = n % 10;
            sum = sum + rem;
            n = n / 10;
        }
        System.out.println("the sum of digit of number : " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sumofdigit s = new sumofdigit();
        System.out.println("enter the number");
        int x = sc.nextInt();
        s.digitSum(x);
        sc.close();

    }
}
