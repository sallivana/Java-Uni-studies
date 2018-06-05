//Task_5:
//        Создать приложение с 3 потоками для следующей задачи:
//        3 работника выполняют следующую работу:
//        1-ый копает яму,
//        2-ой сажает дерево,
//        3-ий подвязывает саженец к кольям.
//        Работа идет строго по очереди. Число саженцев задается параметром.
//        Выводить на дисплей номер работника и номер саженца.

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;

public class Main {

    private static final AtomicInteger TreesCount = new AtomicInteger(0);
    private static final AtomicInteger diggedHoles = new AtomicInteger(0);
    private static final AtomicInteger plantedTrees = new AtomicInteger(0);
    private static final AtomicInteger readyTrees = new AtomicInteger(0);
    private static final BlockingQueue<Integer> hole = new LinkedBlockingQueue<>();
    private static final BlockingQueue<Integer> plant = new LinkedBlockingQueue<>();
    private static final CyclicBarrier barrier = new CyclicBarrier(3);

    private static int tryReadInt(final String value, final Scanner scanner) {
        do {
            System.out.print(value);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Должно быть введено число");
                scanner.next();
            }
        } while (true);
    }

    private static final Runnable dig = () -> {
        while (diggedHoles.get() != TreesCount.get()) {
            try {
                final int id = diggedHoles.incrementAndGet();
                System.err.println("копаю " +id+ " яму");
                hole.add(id);
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static final Runnable planter = () -> {
        while (plantedTrees.get() != TreesCount.get()) {
            try {
                final Integer id = hole.take();
                System.err.println("сажаю " +id+ " саженец");
                plantedTrees.set(id);
                plant.add(id);
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static final Runnable bind = () -> {
        while (readyTrees.get() != TreesCount.get()) {
            try {
                final Integer id = plant.take();
                System.err.println("подвязываю " +id+ " саженец");
                readyTrees.getAndIncrement();
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int trees = tryReadInt("Сколько деревьев сажать?\n", scanner);
        scanner.close();
        TreesCount.set(trees);
        new Thread(dig).start();
        new Thread(planter).start();
        new Thread(bind).start();
    }
}