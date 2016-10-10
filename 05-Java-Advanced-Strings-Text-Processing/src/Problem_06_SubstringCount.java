import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Problem_06_SubstringCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputText = bf.readLine().toLowerCase();
        String substring = bf.readLine().toLowerCase();
        int indexSubstring = 0;
        long counter = 0;

        while (true){
            indexSubstring = inputText.indexOf(substring,indexSubstring);

            if (indexSubstring >= 0){
                counter++;
            } else {
                break;
            }
            indexSubstring++;

        }
        System.out.println(counter);
        bf.close();
    }
}
