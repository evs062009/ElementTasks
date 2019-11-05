package task5NumberToText.mappers;

public class Mapper implements IMapper {
    @Override
    public String getZero() {
        return "ноль";
    }

    @Override
    public String getMinus() {
        return "минус ";
    }

    @Override
    public String[][] getNumberNames() {
        return new String[][]{
                {"", "один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "},

                {"", "одиннадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
                        "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать "},

                {"", "", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ",
                        "восемьдесят ", "девяносто "},

                {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ",
                        "восемьсот ", "девятьсот "}
        };
    }

    @Override
    public String[][] getBlockNames() {
        return new String{
            {"", "одна тысяча ", "две тысячи ", "три тысячи ", "четыре тысячи ", "пять тысяч ", "шесть ", "семь ", "восемь ", "девять "}
        };
    }


}
