import java.util.Scanner;

public class Problem_03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = scan.nextInt();
        double secondNum = scan.nextDouble();
        double thirdNum = scan.nextDouble();

        String firstNumAsHex = String.format("%-10s",
                Integer.toHexString(firstNum).toUpperCase());
        String firstNumAsBin = String.format("%10s",
                Integer.toBinaryString(firstNum)).replace(' ', '0');

        System.out.println(String.format("|%s|%s|%,10.2f|%-10.3f|",
                firstNumAsHex,firstNumAsBin, secondNum,thirdNum));
    }
}
