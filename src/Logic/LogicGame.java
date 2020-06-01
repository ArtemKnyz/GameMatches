package Logic;

import Data.Data;

import java.util.Random;
import java.util.Scanner;

public class LogicGame {
    private boolean firstMove;
    Scanner scanner = new Scanner(System.in);
    Data data = new Data();

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public void startGame() {
        data.setCount(20);
        if (!firstMove) {
            System.out.print("Я убираю 3 спички. ");
            data.value(3);
            System.out.println("Осталось " + data.getCount() + " спичек.");
            generalLogic();
        } else {
            boolean flag = true;
            M:
            while (flag) {
                System.out.print("Ваш ход. Сколько спичек вы хотите убрать? ");
                int variable = scanner.nextInt();
                if (variable >= data.getCount()) {
                    System.out.println("число не может быть больше остатка:" + data.getCount());
                    continue;
                }
                if (variable > 0 & variable < 4) {
                    data.value(variable);
                    if (data.getCount() == 1) {
                        System.out.println("Поздравляю! Вы победили!!! ");
                        return;
                    }
                    System.out.print("Осталось " + data.getCount() + ". ");
                    int[] win = {3, 7, 11, 15};

                    if ((data.getCount() - 1) % 4 == 0 && data.getCount() != 1) {
                        System.out.println("Ищем 7.|11|15..");
                        int varChange = (int) (1 + Math.random() * 3);
                        System.out.print("Я убираю " + varChange + ", ");
                        data.value(varChange);
                        System.out.println("осталось " + data.getCount());
                        continue;
                    } else {
                        switch (variable) {
                            case 1 -> {
                                System.out.print("Я убираю 2 спички, ");
                                data.value(2);
                                System.out.println("осталось " + data.getCount());
                                break;
                            }
                            case 2 -> {
                                System.out.print("Я убираю 1 спичку, ");
                                data.value(1);
                                System.out.println("осталось " + data.getCount());
                                break;
                            }
                            case 3 -> {
                                System.out.println("Я убираю 3 спички, ");
                                data.value(3);
                                System.out.println("осталось " + data.getCount());
                                flag = false;
                                break;
                            }
                        }
                    }

                } else {
                    System.out.println("Вы должны выбрать от 1 до 3 спичек");
                    startGame();
                }
                flag = false;
                generalLogic();
            }
        }
    }

    public void generalLogic() {
        for (int i = 0; i < data.getCount() - 1; ) {
            System.out.print("Ваш ход. Cколько спичек Вы хотите убрать? ");
            int var = scanner.nextInt();
            if (var > 0 & var < 4) {
                data.value(var);
                System.out.print("Осталось " + data.getCount() + ". ");
                switch (var) {
                    case 1 -> {
                        System.out.print("Я убираю 3 спички, ");
                        data.value(3);
                        System.out.println("осталось " + data.getCount());
                    }
                    case 2 -> {
                        System.out.print("Я убираю 2 спички, ");
                        data.value(2);
                        System.out.println("осталось " + data.getCount());
                    }
                    case 3 -> {
                        System.out.print("Я убираю 1 спичку, ");
                        data.value(1);
                        System.out.println("осталось " + data.getCount());
                    }
                    default -> System.out.println("Error");
                }
            } else {
                System.out.println("Вы должны выбрать от 1 до 3 спичек");
            }
            if (data.getCount() == 1) {
                System.out.println("Вы проиграли ");
            }
        }
    }
}