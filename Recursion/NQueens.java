package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    boolean isSafe1(int row, int col, List<String> board, int n) {

        // check upper diagonal
        int duprow = row;
        int dupcol = col;

        while(row >= 0 && col >= 0) {

            if(board.get(row).charAt(col) == 'Q')
                return false;

            row--;
            col--;
        }

        col = dupcol;
        row = duprow;

        while(col >= 0) {

            if(board.get(row).charAt(col) == 'Q')
                return false;

            col--;
        }

        row = duprow;
        col = dupcol;

        while(row < n && col >= 0) {

            if(board.get(row).charAt(col) == 'Q')
                return false;

            row++;
            col--;
        }

        return true;
    }

    public void solve(int col, List<String> board,
                      List<List<String>> ans, int n) {

        if(col == n) {

            ans.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row < n; row++) {

            if(isSafe1(row, col, board, n)) {

                char[] ch = board.get(row).toCharArray();
                ch[col] = 'Q';
                board.set(row, new String(ch));

                solve(col + 1, board, ans, n);

                ch = board.get(row).toCharArray();
                ch[col] = '.';
                board.set(row, new String(ch));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        List<String> board = new ArrayList<>();

        String s = ".".repeat(n);

        for(int i = 0; i < n; i++) {

            board.add(s);
        }

        solve(0, board, ans, n);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        NQueens obj = new NQueens();

        List<List<String>> ans = obj.solveNQueens(n);

        for(List<String> board : ans) {

            for(String row : board) {

                System.out.println(row);
            }

            System.out.println();
        }
    }
}
