package Recursion;

import java.util.ArrayList;

public class CountSubsequenceWithSumK {
    static int printS(int ind, ArrayList<Integer> ds, int s, int sum, int arr[], int n) {

        // Base condition
        if (ind == n) {

            // Condition satisfied
            if (s == sum) {
                return 1;
            }

            // Condition not satisfied
            else {
                return 0;
            }
        }

        // Pick the element
        ds.add(arr[ind]);
        s += arr[ind];

        int l = printS(ind + 1, ds, s, sum, arr, n);

        // Backtrack
        s -= arr[ind];
        ds.remove(ds.size() - 1);

        // Not pick the element
        int r = printS(ind + 1, ds, s, sum, arr, n);

        return l + r;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 1};
        int n = arr.length;
        int sum = 2;

        ArrayList<Integer> ds = new ArrayList<>();

        int count = printS(0, ds, 0, sum, arr, n);

        System.out.println("Count of subsequences with sum " + sum + " = " + count);
    }
}
