import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Problem_03_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numLines = Integer.parseInt(scan.nextLine());
        Stack<Long> stack = new Stack<>();
        Stack<Long> maxStack = new Stack<>();
        long maxElement = Long.MIN_VALUE;

        for (int i = 0; i < numLines; i++) {
            String inputLine = scan.nextLine();

            if (inputLine.length() > 1){
                long numberToPush = Long.parseLong(inputLine.split(" ")[1]);
                stack.push(numberToPush);
                if (numberToPush >= maxElement){
                    maxElement = numberToPush;
                    maxStack.push(maxElement);

                }
            } else if(inputLine.equals("2")){
                long poppedElement = stack.pop();
                if (poppedElement == maxElement){
                    maxStack.pop();
                    if (maxStack.size()>0){
                        maxElement = maxStack.peek();
                    } else {
                        maxElement = Long.MIN_VALUE;
                    }

                }
            } else {
                System.out.println(maxElement);
            }

        }
    }
}
