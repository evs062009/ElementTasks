package task1ChessBoard;

public class ChessBoard implements IChessBoard {

    @Override
    public void printChessBoard(int height, int width)
            throws IllegalArgumentException {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Height and width have to be greater than 0.");
        }
        for (int i = 0; i < height; i++) {
            printString(width, i);
        }
    }

    protected char getFirst() {
        return '*';
    }

    protected char getSecond() {
        return ' ';
    }

    private void printString(int width, int i) {
        String section = "";
        String end;

        if (i % 2 == 0) {
            section = section + getFirst() + getSecond();
            end = "" + getFirst();
        } else {
            section = section + getSecond() + getFirst();
            end = "" + getSecond();
        }

        int halfWidth = width / 2;
        for (int j = 0; j < halfWidth; j++) {
            System.out.print(section);
        }
        if (width % 2 != 0) {
            System.out.print(end);
        }
        System.out.println();
    }
}
