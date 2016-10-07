
import java.util.Scanner;
import java.util.Stack;

public class Problem_10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfLines = scan.nextInt();
        scan.nextLine();

        Stack<Character> stack = new Stack<>();
        Stack<String> commands = new Stack<>();
        Stack<String> erasedValues = new Stack<>();
        Stack<String> pushedValues = new Stack<>();


        for (int i = 0; i < numOfLines; i++) {
            String[] currLine = scan.nextLine().split(" ");
            String command = currLine[0];
            String valueCommand = "";
            if (!command.equals("4")){
                valueCommand = currLine[1];
            }

            switch (command) {
                case "1": pushElements(stack, valueCommand);
                    commands.push("1");
                    pushedValues.push(valueCommand);
                    break;
                case "2": erasedValues.push(eraseElements(stack, valueCommand));
                    commands.push("2");
                    break;
                case "3":
                    Stack<Character> cloneStack = (Stack<Character>)stack.clone();
                    char element = getElementAtPosition(cloneStack,
                            Integer.parseInt(valueCommand));
                    System.out.println(element);
                    break;
                case "4":
                    String lastCmd = commands.pop();
                    if (lastCmd.equals("1")){
                        eraseElements(stack,pushedValues.pop().length() + "");
                    } else {
                        pushElements(stack,erasedValues.pop());
                    }
            }
        }
        System.out.println("");
    }

    public static void pushElements(Stack<Character> stack, String valueCommand){
        for (int i = 0; i < valueCommand.length(); i++) {
            char currChar = valueCommand.charAt(i);
            stack.push(currChar);
        }
    }

    public static String eraseElements(Stack<Character> stack, String valueCommand){
        int numOfElementsToErase = Integer.parseInt(valueCommand);
        String erasedElements = "";
        for (int i = 0; i < numOfElementsToErase; i++) {
            erasedElements = stack.pop() + erasedElements;
        }
        return erasedElements;
    }

    public static char getElementAtPosition(Stack<Character> stack, int position){
        char returnElement = ' ';
        int actPosition = stack.size() - position;
        for (int i = 0; i <= actPosition; i++) {
             if (i == actPosition){
                 returnElement = stack.pop();
             } else {
                 stack.pop();
             }
        }
        return returnElement;
    }
}
