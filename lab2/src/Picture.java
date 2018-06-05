// Объявлен класс Picture, реализующий  интерфейс Present

public class Picture implements Present {
    @Override
    public Boolean itCanBePresented() {
        return false;
    }

    @Override
    public String whoAmI() {
        return "a picture";
    }
}