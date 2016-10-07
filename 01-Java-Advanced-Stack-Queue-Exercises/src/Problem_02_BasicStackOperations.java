import java.util.Scanner;
import java.util.Stack;

public class Problem_02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputFirstLine = scan.nextLine().split(" ");
        String[] inputSecondLine = scan.nextLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        int elementsToPush = Integer.parseInt(inputFirstLine[0]);
        int elementsToPop = Integer.parseInt(inputFirstLine[1]);
        int elementToCheck = Integer.parseInt(inputFirstLine[2]);

        for (int i = 0; i < elementsToPush - elementsToPop; i++) {
            stack.push(Integer.parseInt(inputSecondLine[i]));
        }

        if (stack.size() == 0){
            System.out.println("0");
        } else if (stack.contains(elementToCheck)){
            System.out.println("true");
        } else {
            System.out.println(getMinElement(stack));
        }
    }

    public static int getMinElement(Stack<Integer> stack){
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            int currElement = stack.pop();
            if (currElement < minElement){
                minElement = currElement;
            }
        }
        return minElement;
    }
}
