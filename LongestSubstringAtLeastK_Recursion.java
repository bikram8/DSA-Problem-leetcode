public class LongestSubstringAtLeastK_Recursion {
    public static int helper(char[] ch, int start, int end, int k) {

        // If substring length is smaller than k
        if (end - start < k)
            return 0;

        int[] count = new int[26];

        // Count frequency of characters
        for (int i = start; i < end; i++) {
            count[ch[i] - 'a']++;
        }

        // Find invalid character
        for (int i = start; i < end; i++) {

            // If frequency is less than k
            if (count[ch[i] - 'a'] < k) {

                int j = i + 1;

                // Skip consecutive invalid characters
                while (j < end && count[ch[j] - 'a'] < k) {
                    j++;
                }

                // Divide and solve recursively
                return Math.max(
                        helper(ch, start, i, k),
                        helper(ch, j, end, k)
                );
            }
        }

        // Entire substring is valid
        return end - start;
    }

    // Main function
    public static void main(String[] args) {

        String s = "ababbc";
        int k = 3;

        char[] ch = s.toCharArray();

        int result = helper(ch, 0, ch.length, k);

        System.out.println("Longest substring length = " + result);
    }
}
