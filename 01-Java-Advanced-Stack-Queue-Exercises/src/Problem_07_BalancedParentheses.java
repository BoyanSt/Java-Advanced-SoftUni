import java.util.*;

public class Problem_07_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        boolean isBalanced = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputLine.length(); i++) {
             Character currChar = inputLine.charAt(i);

             if (currChar == '(' || currChar == '{' || currChar == '['){
                 stack.push(currChar);
             } else {
                 switch (currChar){
                     case ')': currChar = '('; break;
                     case '}': currChar = '{'; break;
                     case ']': currChar = '['; break;
                 }

                 if (stack.isEmpty()){
                     isBalanced = false;
                     break;
                 }

                 if (currChar != stack.pop()){
                     isBalanced = false;
                     break;
                 }
             }
        }

        if (isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
