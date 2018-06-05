// Task_4:
// Создать приложение, позволяющее читать *.properties-файлы.
// Физическое чтение файла должно происходить только один раз.
// Результаты чтения храните в коллекции типа Map.
// После прочтения файла, пользователь может работать с ним через консоль,
// запрашивая значения по ключам, пока не нажата клавиша ESC.

import java.io.*;
import java.util.HashMap;
//import IdeaProjects.lab4.src.PropReader;

public class Main {
    public static void main(String[] args)
    {
        PropReader propReader = new PropReader("config.prop");
        HashMap<String,String> props = propReader.HashMap();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Введите ключ: ");
                String input = bufferedReader.readLine();
                if (input == null || input.length() == 0 || input.equals("ESC")) {
                    break;
                }
                if (props.containsKey(input)) {
                    System.out.printf("%s is %s\n", input, props.get(input));
                } else {
                    System.out.printf("Такой ключ не существует '%s'\n", input);
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.print("Не удается прочитать");
        }
    }
}

