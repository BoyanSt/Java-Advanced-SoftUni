import java.util.Scanner;

public class Problem_12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        long sumChars = 0;

        StringBuilder firstWord = new StringBuilder(input[0]);
        StringBuilder secondWord = new StringBuilder(input[1]);

        int maxLength = Math.max(firstWord.length(), secondWord.length());
        firstWord.setLength(maxLength);
        secondWord.setLength(maxLength);

        for (int i = 0; i < firstWord.length(); i++) {
            char firstWordChar = firstWord.charAt(i);
            char secondWordChar = secondWord.charAt(i);
            if (firstWordChar != '\u0000' && secondWordChar != '\u0000' ){
                sumChars += firstWord.charAt(i) * secondWord.charAt(i);
            } else {
                sumChars += firstWordChar + secondWordChar;
            }

        }

        System.out.println(sumChars);
    }
}
