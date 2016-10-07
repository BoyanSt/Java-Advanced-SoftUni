import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem_04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbersToAdd = scan.nextInt();
        int numbersToRemove = scan.nextInt();
        int numberToCheck = scan.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        scan.nextLine();

        String[] input = scan.nextLine().split(" ");

        for (int i = 0; i < numbersToAdd; i++) {
            int currElement = Integer.parseInt(input[i]);
            queue.add(currElement);
        }

        for (int i = 0; i < numbersToRemove; i++) {
            queue.remove();
        }

        if (queue.size()==0){
            System.out.println(0);
        } else if (queue.contains(numberToCheck)){
            System.out.println("true");
        } else {
            System.out.println(minElementQueue(queue));
        }
    }

    public static int minElementQueue(Queue<Integer> queue){
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int currElement = queue.remove();
            if (currElement < minElement){
                minElement = currElement;
            }
        }
        return minElement;
    }
}
