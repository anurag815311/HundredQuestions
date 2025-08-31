//package HundredQuestions;

public class powerTwo {

    public static boolean isPowerTwo(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (n % 2 == 0) {
                n = n / 2;
            }
            return n == 1;
        }
    }

    public static void main(String[] args) {
        boolean check = isPowerTwo(4);
        System.out.println(check);
    }
}