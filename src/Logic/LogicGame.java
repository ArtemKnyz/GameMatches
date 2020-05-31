package Logic;

import Data.Data;

import java.util.Scanner;

public class LogicGame {
    boolean firstMove = true;
    Scanner scanner = new Scanner(System.in);
    Data data = new Data();

    public void startGame() {
        data.setCount(20);
        if (firstMove) {
            System.out.print("Я убираю 3 спички. ");
            data.value(3);
            System.out.println("Осталось " + data.getCount() + " спичек.");
            for (int i = 0; i < data.getCount() - 1; ) {

                M:
                System.out.print("Ваш ход. Cколько спичек Вы хотите убрать? ");
                int var = scanner.nextInt();
                if (var > 0 & var < 4) {
                    data.value(var);
                    System.out.print("Осталось " + data.getCount() + " спичек. ");
                    switch (var) {
                        case 1:
                            System.out.print("Я убираю 3 спички ");
                            data.value(3);
                            System.out.println("осталось " + data.getCount());
                            break;
                        case 2:
                            System.out.print("Я убираю 2 спички ");
                            data.value(2);
                            System.out.println("осталось " + data.getCount());
                            break;
                        case 3:
                            System.out.print("Я убираю 1 спичку ");
                            data.value(1);
                            System.out.println("осталось " + data.getCount());
                            break;
                        default:
                            System.out.println("Error");
                    }
                } else {
                    System.out.println("Вы должны выбрать от 1 до 3 спичек");
                    continue;
                }
            }
            if (data.getCount() == 1) {
                System.out.println("Вы проиграли ");
            }
        }else {

        }
    }
}
