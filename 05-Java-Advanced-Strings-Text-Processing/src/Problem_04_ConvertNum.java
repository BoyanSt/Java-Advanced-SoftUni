import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Problem_04_ConvertNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split("\\s+");
        BigInteger numToConvert = new BigInteger(input[1]);
        BigInteger base = new BigInteger(input[0]);
        StringBuilder output = new StringBuilder();

        while (numToConvert.compareTo(BigInteger.ZERO) > 0){
            output.insert(0, numToConvert.remainder(base).toString());
            numToConvert = numToConvert.divide(base);
        }

        System.out.println(output);
        bf.close();
    }
}
