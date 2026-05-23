import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary_watch {

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 12; i++) {       // hours (0–11)
            for (int j = 0; j < 60; j++) {   // minutes (0–59)

                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of LEDs turned on: ");
        int turnedOn = sc.nextInt();

        List<String> result = readBinaryWatch(turnedOn);

        System.out.println("Possible Times:");
        for (String time : result) {
            System.out.println(time);
        }

        sc.close();
    }
}
