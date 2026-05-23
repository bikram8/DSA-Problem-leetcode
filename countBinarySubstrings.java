import java.util.Scanner;

public class countBinarySubstrings {


    public int countBinarySubstrings1(String s) {
        int prev = 0;
        int curr = 1;
        int count = 0;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        count += Math.min(prev, curr);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        countBinarySubstrings sol = new countBinarySubstrings();
        int result = sol.countBinarySubstrings1(s);

        System.out.println("Number of binary substrings: " + result);

        sc.close();
    }
}
