package HundredQuestions;

public class palindromeNumber {
    static boolean palindromeCheck(int n) {
        if (n < 0) {
            return false;
        }
        int x = n;
        int revNum = 0;
        while (x > 0) {
            int rem = x % 10;
            revNum = revNum * 10 + rem;
            x = x / 10;
        }
        if (revNum == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean check = palindromeCheck(121);
        System.out.println(check);
    }
}
