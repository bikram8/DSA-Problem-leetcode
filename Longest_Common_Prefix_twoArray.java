import java.util.HashSet;

public class Longest_Common_Prefix_twoArray {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        // Store all prefixes of arr1 numbers
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            int n = num;

            while (n > 0) {
                set.add(n);
                n /= 10;
            }
        }

        int max = 0;

        // Check prefixes of arr2 numbers
        for (int num : arr2) {

            int n = num;
            int len = helper(num);

            while (n > 0) {

                if (set.contains(n)) {
                    max = Math.max(max, len);
                    break;
                }

                n /= 10;
                len--;
            }
        }

        return max;
    }

    // Function to count number of digits
    private int helper(int num) {

        int len = 0;

        while (num > 0) {
            len++;
            num /= 10;
        }

        return len;
    }

    // Main function
    public static void main(String[] args) {

        Longest_Common_Prefix_twoArray obj = new Longest_Common_Prefix_twoArray();

        int[] arr1 = {12345, 567, 12, 98};
        int[] arr2 = {123, 569, 1299, 9};

        int result = obj.longestCommonPrefix(arr1, arr2);

        System.out.println("Longest Common Prefix Length: " + result);
    }
}
