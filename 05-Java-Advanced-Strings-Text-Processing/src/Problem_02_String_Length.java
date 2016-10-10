import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_02_String_Length {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bf.readLine();

        StringBuilder output = new StringBuilder(inputString);
        output.append(new String(new char[20]).replace('\0','*'));
        output.delete(20,output.length());
        System.out.println(output);
        bf.close();
    }
}
