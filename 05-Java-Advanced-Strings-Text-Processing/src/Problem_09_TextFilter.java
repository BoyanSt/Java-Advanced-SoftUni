import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_09_TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = bf.readLine().split(", ");
        String text = bf.readLine();

        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord,
                    new String(new char[bannedWord.length()]).replace('\0','*'));
        }

        System.out.println(text);
        bf.close();
    }
}
