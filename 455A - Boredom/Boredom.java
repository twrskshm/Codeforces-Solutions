import java.util.HashMap;
import java.util.Scanner;

/**
 * Boredom
 *
 * Time complexity:
 * Worst case: Θ(n)
 * Best case: Θ(n)
 *
 * Space complexity:
 * Worst case: Θ(n)
 * Best case: Θ(n)
 *
 * @author Saksham Tiwari
 */

public class Boredom {
    /**
     * Function that prints maximum number of points Alex can earn.
     * @param arguments Arguments passed with run command.
     */
    public static void main(final String[] arguments) {
        final Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        final HashMap<Integer, Integer> counter = new HashMap<>();
        int maximumElement = 0;

        while (n-- > 0) {
            int element = input.nextInt();
            counter.put(element, counter.getOrDefault(element, 0) + 1);
            maximumElement = Math.max(maximumElement, element);
        }

        final HashMap<Integer, Long> dp = new HashMap<>();
        dp.put(0, 0L);
        dp.put(1, (long) counter.getOrDefault(1, 0));

        for (int element = 2; element <= maximumElement; element++) {
            final long result = Math.max(dp.getOrDefault(element - 2, 0L) + element * (long) counter.getOrDefault(element, 0), dp.getOrDefault(element - 1, 0L));
            dp.put(element, result);
        }

        System.out.println(dp.get(maximumElement));
    }
}
