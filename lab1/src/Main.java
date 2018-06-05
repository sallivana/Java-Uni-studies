
// Task_1:
// Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
// Размеры отрезка и параметры задаются в качестве параметров в консоли.
// Результат представить в виде таблицы, первый столбец которой – значения аргумента,
// второй - соответствующие значения функции: F(x) = tg(2x) - 3

import java.lang.System;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        if (args.length != 3) {
            throw new RuntimeException("\nДолжно быть три значения: начало отрезка, конец и шаг");
        }
        int a, b, h;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            h = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("\nАргументы должны являться целыми числами");
        }
        if (b <= a) {
            throw new RuntimeException("\nЗначение конца отрезка должно быть больше, чем начала");
        }
        System.out.print("x\tF(x)\n");
        for (int i = a; i <= b; i += h) {
            double f = Math.tan(2 * i) - 3;
            System.out.print( i + "\t" + f + "\n");
        }
    }
}