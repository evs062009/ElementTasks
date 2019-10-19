package task1ChessBoard;

import utilities.IOUtilities;

public class Main {

    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            IOUtilities.printlnWithEmptyLine(
                    "It needs 2 integer parameters: numbers of rows and columns.");
            return;
        }

        IChessBoard chessBoard = new ChessBoard();
        try {
            chessBoard.printChessBoard(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
