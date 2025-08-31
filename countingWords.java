//package HundredQuestions;

public class countingWords {

    public static void wordCount(String s) {
        int vowels = 0;
        int consonents = 0;
        int spaces = 0;
        for (char c : s.toCharArray()) {
            if (Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i'
                    || Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u') {
                vowels++;
            } else if (Character.isAlphabetic(c)) {
                consonents++;
            } else if (Character.isSpaceChar(c)) {
                spaces++;
            }
        }

        System.out.println(" The number of Vowles : " + vowels);
        System.out.println("The number of Consonents :" + consonents);
        System.out.println("The number of spaces :" + spaces);

    }

    public static void main(String[] args) {
        String s = " Hey there Buddy!";
        wordCount(s);
    }
}
