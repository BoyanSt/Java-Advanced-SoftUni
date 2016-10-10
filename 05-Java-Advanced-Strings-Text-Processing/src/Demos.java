
public class Demos {
    public static void main(String[] args) {
        String cocktail = "beer    ((444^^^,,,vodka ,,,44^^   rum";
        cocktail = cocktail.replaceAll("[\\s(0-9)^,,]+", " ");
        System.out.println(cocktail);

        StringBuilder output = new StringBuilder();
        int[] arr = new int[]{5, 6, 8, 10};

        for (int i = 0; i < arr.length; i++) {
            output.append(String.format("%d, ", arr[i]));
        }
        output.setLength(output.length() - 2);
        System.out.println(output);

    }
}
