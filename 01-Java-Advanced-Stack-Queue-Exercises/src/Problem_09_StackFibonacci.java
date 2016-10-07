import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem_09_StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Long> stack = new Stack<>();
        stack.push((long)1);
        stack.push((long)1);

        for (int i = 0; i < n; i++) {
            long lastNum = stack.pop();
            long previousNum = stack.peek();
            long nextFibonacciNum = lastNum + previousNum;
            stack.push(nextFibonacciNum);
            stack.push(previousNum);
        }
        System.out.println(stack.peek());
    }
}
