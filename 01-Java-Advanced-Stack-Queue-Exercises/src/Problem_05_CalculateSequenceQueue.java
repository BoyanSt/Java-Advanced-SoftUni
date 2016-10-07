import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem_05_CalculateSequenceQueue {
    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        Queue<Long> queue = new ArrayDeque<>();

        queue.add(num);


        for (int i = 0; i < 50; i++) {
            long currNum = queue.remove();
            System.out.printf("%s ", currNum);
            long s1 = currNum + 1;
            long s2 = 2 * currNum + 1;
            long s3 = currNum + 2;

            queue.add(s1);
            queue.add(s2);
            queue.add(s3);

        }

    }
}
