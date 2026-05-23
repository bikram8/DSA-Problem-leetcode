import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SpecialBinaryString {
    public static String makeLargestSpecial(String s) {

        List<String> specials = new ArrayList<>();

        int start = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            sum += (s.charAt(i) == '1') ? 1 : -1;

            if (sum == 0) {

                // Extract inner substring
                String inner = s.substring(start + 1, i);

                // Recursive call
                specials.add("1" + makeLargestSpecial(inner) + "0");

                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(specials, Collections.reverseOrder());

        // Build result
        StringBuilder result = new StringBuilder();

        for (String str : specials) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter special binary string:");
        String input = sc.nextLine();

        String answer = makeLargestSpecial(input);

        System.out.println("Largest Special String: " + answer);

        sc.close();
    }
}
