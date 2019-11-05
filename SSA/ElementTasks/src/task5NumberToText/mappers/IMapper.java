package task5NumberToText.mappers;

public interface IMapper {
    String getZero();

    String getMinus();

    String[][] getNumberNames();

    default String getNumberName(int digit, int number) {
        return getNumberNames()[digit][number];
    }

    String[][] getBlockNames();

    default String getBlockName(int i, int j) {
        return getBlockNames()[i][j];
    }
}

