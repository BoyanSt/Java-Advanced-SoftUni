import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String textToShake = bf.readLine();
        String pattern = bf.readLine();
        boolean isShake = true;

        while (isShake){
            int firstAppearance = textToShake.indexOf(pattern);
            int lastAppearance = textToShake.lastIndexOf(pattern);

            if (firstAppearance != -1 && lastAppearance != -1 &&
                    firstAppearance != lastAppearance){
                int indexChar = pattern.length()/2;
                System.out.println("Shaked it.");
                
                // Update text
                textToShake = textToShake.substring(0,firstAppearance) +
                        textToShake.substring(firstAppearance + pattern.length(), lastAppearance) +
                        textToShake.substring(lastAppearance + pattern.length());

                // Update pattern
                pattern = pattern.substring(0,indexChar) +
                        pattern.substring(indexChar + 1, pattern.length());
            } else {
                isShake = false;
                System.out.println("No shake.");
                System.out.println(textToShake);
            }

            if (pattern.equals("")){
                isShake = false;
                System.out.println("No shake.");
                System.out.println(textToShake);
            }
        }

    }
}
