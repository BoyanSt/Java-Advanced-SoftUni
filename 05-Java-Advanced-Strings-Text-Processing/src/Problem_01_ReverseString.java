import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_01_ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bf.readLine();

        StringBuilder output = new StringBuilder();
        for (int i = inputString.length() - 1; i >= 0 ; i--) {
             output.append(inputString.charAt(i));
        }
        System.out.println(output);
        bf.close();
    }
}
