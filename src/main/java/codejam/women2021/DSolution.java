package codejam.women2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DSolution {
    static String readpath = "./ins/small-practice.in";
    static String outpath = "./outs/small-practice.txt";
    public static void main(String[] args) throws IOException {
        // read file
//        Scanner in = new Scanner(new FileReader(readpath));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // get total number
        int T = in.nextInt();
        // handle each task
        for(int i=0; i<T; i++){
            // get number of ingredients
            String current  = in.next();
            Result r = new DSolution().getResult(current, 0, current.length(), 'I');
            System.out.println("Case #" + (i + 1) + ": " + r.winner + " " + r.maxWon);
//            out.append("Case #" + (i + 1) + ": " + r.winner + " " + r.maxWon + '\n');

        }
        in.close();
//        out.close();
    }

    public Result getResult(String cards, int begin, int end, char currentPlayer) {
        if (end - begin >= 2) {
            char l = cards.charAt(begin);
            char r = cards.charAt(end - 1);
            if (l == currentPlayer &&  r == currentPlayer) {
                if (cards.charAt(begin + 1) == currentPlayer) {
                    return getResult(cards, begin+1, end, getNextPlayer(currentPlayer));
                }

                if (cards.charAt(end - 1 - 1) == l) {
                    return getResult(cards, begin, end - 1, getNextPlayer(currentPlayer));
                }
                Result chooseleft = getResult(cards, begin + 1, end, getNextPlayer(currentPlayer));
                Result chooseright = getResult(cards, begin, end - 1, getNextPlayer(currentPlayer));
                return betterResult(currentPlayer, chooseleft, chooseright);
            } else if (l == currentPlayer) {
                return getResult(cards, begin + 1, end, getNextPlayer(currentPlayer));
            } else if (r == currentPlayer) {
                return getResult(cards,  begin, end - 1, getNextPlayer(currentPlayer));
            } else {
                return new Result(getNextPlayer(currentPlayer), end - begin + 1);
            }
        } else {
            if (currentPlayer == cards.charAt(begin)) {
                return new Result(currentPlayer, 1);
            } else {
                return new Result(getNextPlayer(currentPlayer), 2);
            }
        }
    }

    public Result betterResult (char player, Result r1, Result r2) {
        if (r1.winner == player && r2.winner == player) {
            int max = Math.max(r1.maxWon, r2.maxWon);
            return new Result(player, max);
        } else if (r1.winner == player) {
            return r1;
        } else if (r2.winner == player) {
            return r2;
        } else {
            int min = Math.min(r1.maxWon, r2.maxWon);
            return new Result(r1.winner, min);
        }
    }

    public char getNextPlayer(char player) {
        if (player == 'I') {
            return 'O';
        } else {
            return 'I';
        }
    }
    public class Result {
        char winner;
        int maxWon;

        public Result(char winner, int maxWon) {
            this.winner = winner;
            this.maxWon = maxWon;
        }


    }
}
