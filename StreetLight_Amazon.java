/* You are given an array T of size N, where T[i] signifies the position of house i
on the x-axis. Consider each house to be point-sized. Additionally, you are given an array
S of size M, where S[i] signifies the position of streetlight i on the same x-axis.
 Note that a house and a streetlight can be placed at the same x-coordinate.
Return the integer k, which is the maximum distance between any streetlight i and any house j such
 that streetlight i illuminates house j. Note that any streetlight can illuminate a house at an
 infinite distance away.

*/

import java.util.Arrays;

public class StreetLight_Amazon {

    public static int maxDistance(int[] T, int[] S) {

        // sort streetlights
        Arrays.sort(S);

        int ans = 0;

        // process every house
        for (int house : T) {

            int idx = Arrays.binarySearch(S, house);

            // if exact streetlight exists
            if (idx >= 0) {
                continue;
            }

            // insertion point
            idx = -(idx + 1);

            int leftDist = Integer.MAX_VALUE;
            int rightDist = Integer.MAX_VALUE;

            // nearest streetlight on left
            if (idx - 1 >= 0) {
                leftDist = house - S[idx - 1];
            }

            // nearest streetlight on right
            if (idx < S.length) {
                rightDist = S[idx] - house;
            }

            // nearest distance for current house
            int nearest = Math.min(leftDist, rightDist);

            // update maximum
            ans = Math.max(ans, nearest);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] T = {1, 5, 10};
        int[] S = {2, 6};

        int result = maxDistance(T, S);

        System.out.println("Maximum Distance = " + result);
    }
}

/* --------- with binary search ----------
   public static int maxDistance(int[] T, int[] S) {

        // sort streetlights for binary search
        Arrays.sort(S);

        int ans = 0;

        // check every house
        for (int house : T) {

            // binary search on streetlights array
            int idx = Arrays.binarySearch(S, house);

            // if exact streetlight found
            if (idx >= 0) {
                continue;
            }

            // recover insertion point
            idx = -(idx + 1);

            int leftDist = Integer.MAX_VALUE;
            int rightDist = Integer.MAX_VALUE;

            // streetlight on left side
            if (idx - 1 >= 0) {
                leftDist = house - S[idx - 1];
            }

            // streetlight on right side
            if (idx < S.length) {
                rightDist = S[idx] - house;
            }

            // nearest streetlight distance
            int nearest = Math.min(leftDist, rightDist);

            // maximum among all houses
            ans = Math.max(ans, nearest);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] T = {1, 5, 10};
        int[] S = {2, 6};

        int result = maxDistance(T, S);

        System.out.println("Maximum Distance = " + result);
    }



 */
