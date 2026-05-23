public class LongestSubstringwithAtLeastKRepeatingCharacters {


    public int longestSubstring(String s, int k) {

        int n = s.length();
        int ans = 0;

        // Try all possible unique character counts
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {

            int[] freq = new int[26];

            int left = 0;
            int right = 0;

            int uniqueChars = 0;
            int charsAtLeastK = 0;

            while (right < n) {

                // Expand window
                int idx = s.charAt(right) - 'a';

                if (freq[idx] == 0)
                    uniqueChars++;

                freq[idx]++;

                if (freq[idx] == k)
                    charsAtLeastK++;

                right++;

                // Shrink window if unique chars exceed target
                while (uniqueChars > targetUnique) {

                    int leftIdx = s.charAt(left) - 'a';

                    if (freq[leftIdx] == k)
                        charsAtLeastK--;

                    freq[leftIdx]--;

                    if (freq[leftIdx] == 0)
                        uniqueChars--;

                    left++;
                }

                // Valid window
                if (uniqueChars == targetUnique &&
                        charsAtLeastK == targetUnique) {

                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        LongestSubstringwithAtLeastKRepeatingCharacters obj = new LongestSubstringwithAtLeastKRepeatingCharacters();

        String s = "aaabb";
        int k = 3;

        int result = obj.longestSubstring(s, k);

        System.out.println("Longest Substring Length: " + result);
    }

}
