import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("\\s+");
        char firstLetter;
        char secondLetter;
        double number = 0;
        double totalSum = 0;



        for (String currString : input) {
            firstLetter = currString.charAt(0);
            secondLetter = currString.charAt(currString.length() - 1);
            number = Double.parseDouble(currString.substring(1, currString.length() - 1));

            if(firstLetter >= 'a' && firstLetter <= 'z'){
                number *= firstLetter - 'a' + 1;
            } else {
                number /= firstLetter - 'A' + 1;
            }

            if (secondLetter >= 'a' && secondLetter <= 'z'){
                number += secondLetter - 'a' + 1;
            } else {
                number -= secondLetter - 'A' + 1;
            }

            totalSum += number;
        }

        System.out.println(String.format("%.2f", totalSum));
    }
}
