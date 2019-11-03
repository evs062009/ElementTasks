package task1ChessBoard;

import utilities.IOUtilities;

public class ChessBoard implements IChessBoard {

    @Override
    public void printChessBoard(int height, int width)
            throws IllegalArgumentException {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Height and width have to be greater than 0.");
        }
        for (int i = 0; i < height; i++) {
            printChessBoardLine(width, i);
        }
    }

    protected String getFirst() {
        return "*";
    }

    protected String getSecond() {
        return " ";
    }

    private void printChessBoardLine(int length, int lineNumber) {
        String section;
        String end;

        if (lineNumber % 2 == 0) {
            section = getFirst().concat(getSecond());
            end = getFirst();
        } else {
            section = getSecond().concat(getFirst());
            end = getSecond();
        }

        int halfWidth = length / 2;
        for (int j = 0; j < halfWidth; j++) {
            IOUtilities.print(section);
        }
        if (length % 2 != 0) {
            IOUtilities.print(end);
        }
        IOUtilities.println("");
    }
}
