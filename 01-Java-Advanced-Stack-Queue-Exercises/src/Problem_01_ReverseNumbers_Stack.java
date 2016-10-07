import java.util.Scanner;
import java.util.Stack;

public class Problem_01_ReverseNumbers_Stack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        String[] inputNums = scan.nextLine().split(" ");
        for (String num : inputNums) {
            stack.push(num);
        }

        StringBuilder output = new StringBuilder();
        for (String inputNum : inputNums) {
            output.append(stack.pop() + " ");
        }

        System.out.println(output);

    }
}
