// Task_3:
// Создать приложение, позволяющее читать значение по ключу из *.properties-файлов.
// В качестве входных параметров (в консоли) задаются: имя файла и ключ, для которого нужно получить значение.
// Обработать все возможные исключительные ситуации.


import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args)
    {
        FileInputStream input = null;
        Properties properties = new Properties();

        try { //проверка на наличие нужного файла
            input = new FileInputStream("config.prop");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден\n");
            return;
        }

        try { //проверка на ошибку ввода-вывода
            properties.load(input);
        }
        catch (IOException e) {
            System.out.println("Не удается прочитать\n");
            return;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("\nВведите ключ: ");
                String iput = bufferedReader.readLine();
                if (iput == null || iput.length() == 0) {
                    break;
                }
                if (properties.containsKey(iput)) {
                    System.out.printf("%s is %s\n", iput, properties.getProperty(iput));
                } else {
                    System.out.println("Такого ключа нет");
                }
            }
            bufferedReader.close();

        }
        catch (IOException e) {
            System.out.println("Не удается прочитать\n");
        }
    }
}