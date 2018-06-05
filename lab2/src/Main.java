// Task_2:
// 1) Создать приложение с 2 классами - Book, Shoe  и  интерфейсом Product.
// Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах.
// 2) Определить новый интерфейс Present, расширяющий интерфейс Product и содержащий  метод itCanBePresented(), который может возвращать строку.
// 3) Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.

// 4) В приложении создать массив объектов Product - (Book, Shoe, Toy, Picture),
// состоящий из количества элементов, заданного параметром.
// 5) Найти в массиве те объекты, которые реализуют интерфейс Present и выполнить для них метод itCanBePresented().

//Вывод должен содержать названия всех продуктов из массива, затем только тех продуктов, которые реализуют интерфейс Present.

public class Main {
    public static void main(String[] args)
    {
        Product[] products = {
                new Book(),
                new Shoe(),
                new Toy(),
                new Picture()
        };

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].whoAmI());
        }

        System.out.println("What present do you want?");
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Present) {
                System.out.println(products[i].whoAmI()+ "\t" +
                        ((Present)products[i]).itCanBePresented()
                );
            }
        }
    }
}