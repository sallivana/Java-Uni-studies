// Объявлен класс Toy, реализующий  интерфейс Present

public class Toy implements Present {

    @Override
    public Boolean itCanBePresented() {
        return true;
    }

    @Override
    public String whoAmI() {
        return "a toy";
    }
}