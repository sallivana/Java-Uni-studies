// Определен интерфейс Present,
// расширяющий интерфейс Product
// и содержащий  метод itCanBePresented(), который может возвращать строку

public interface Present extends Product {
    Boolean itCanBePresented();
}