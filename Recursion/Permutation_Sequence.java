package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        String ans = "";
        List<Integer> list = new ArrayList<>();
        int fact = 1;

        // Calculate factorial and store numbers
        for (int i = 1; i < n; i++) {
            fact *= i;
            list.add(i);
        }
        list.add(n);

        // Convert k to 0-based index
        k = k - 1;

        while (true) {

            ans = ans + list.get(k / fact);
            list.remove(k / fact);

            if (list.size() == 0)
                break;

            k = k % fact;
            fact = fact / list.size();
        }

        return ans;
    }

    // Main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Permutation_Sequence  obj = new Permutation_Sequence ();

        String result = obj.getPermutation(n, k);

        System.out.println("Kth Permutation: " + result);

        sc.close();
    }
}
