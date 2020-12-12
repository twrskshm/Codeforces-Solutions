import java.util.Scanner;

/**
 * Two Substrings
 *
 * Time complexity:
 * Worst case: Θ(n)
 * Best case: Θ(n)
 *
 * Space complexity:
 * Worst case: Θ(1)
 * Best case: Θ(1)
 *
 * @author Saksham Tiwari
 */

public class TwoSubstrings {
    /**
     * Function that checks if a string contains two non-overlapping substrings 'AB' and 'BA'.
     * @param arguments Arguments passed with run command.
     */
    public static void main(final String[] arguments) {
        final Scanner input = new Scanner(System.in);
        final String string = input.next();
        int stringOneEnd = 0;
        int stringTwoEnd = 0;
        int overlapEnd = 0;
        String result = "NO";

        for (int index = 1; index < string.length(); index++) {
            final char previousCharacter = string.charAt(index - 1);
            final char currentCharacter = string.charAt(index);

            if (currentCharacter == 'B' && previousCharacter == 'A') {
                // String one found.
                stringOneEnd = index;
            } else if (currentCharacter == 'A' && previousCharacter == 'B') {
                // String two found.
                stringTwoEnd = index;
            }

            if ((stringOneEnd > 0 && stringTwoEnd > 0) && (stringOneEnd == stringTwoEnd - 1 || stringTwoEnd == stringOneEnd - 1)) {
                // Strings overlap.
                overlapEnd = index;
                stringOneEnd = 0;
                stringTwoEnd = 0;
                index++;
            }

            if ((overlapEnd == 0 && stringOneEnd > 0 && stringTwoEnd > 0) || (overlapEnd > 0 && (stringOneEnd > 0 || stringTwoEnd > 0))) {
                result = "YES";
                break;
            }
        }

        System.out.println(result);
    }
}
