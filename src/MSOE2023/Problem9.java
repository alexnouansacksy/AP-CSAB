package MSOE2023;
import static java.lang.System.out;
import java.util.*;

public class Problem9 {
    public static boolean horizon(String[][] board, int r, int c, String word) {
        String letter = board[r][c];
        int location = word.indexOf(letter);
        //String before = index;
        //String after =
        return false;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word = keyboard.nextLine();
        ArrayList<String> board = new ArrayList<>();
        while (keyboard.hasNext()) {
            String line = keyboard.nextLine();
            board.add(line);
        }

        String[][] realBoard = new String[board.size()][board.get(0).length()];

        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.get(0).length(); c++) {
                realBoard[r][c] = board.get(r).substring(c, c+1);
            }
        }

        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.get(0).length(); c++) {
                out.print(realBoard[r][c]);
            }
            out.println();
        }
    }
}
