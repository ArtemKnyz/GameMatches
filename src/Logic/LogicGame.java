package Logic;

import Data.Data;
import java.util.Scanner;

public class LogicGame extends Exception {
    private boolean checkEndGame;
    private boolean programExecutionCheck = true;
    private int counterMovePlayer;

    Data data = new Data();

    void movePlayer() {
        Scanner scanner = new Scanner(System.in);
        boolean checkMovePlayer = false;
        while (!checkMovePlayer) {
            System.out.print("Ваш ход. Сколько спичек вы хотите убрать? ");
            try {
                counterMovePlayer = scanner.nextInt();
            } catch (Exception ex) {
                System.err.print("ввести нужно цифру! \n");
                scanner.nextLine();
                continue;
            }
            if (!checkValue(counterMovePlayer)) {
                continue;
            }
            checkMovePlayer = true;
        }
        data.value(counterMovePlayer);
        System.out.println("осталось: " + data.getCount());
    }

    boolean checkEndGame() {
        checkEndGame = false;
        if (data.getCount() == 1) {
            System.out.print("Game over! ");
            checkEndGame = true;
        }
        return checkEndGame;
    }

    public void startGame() {
        data.setCount(20);
        while (programExecutionCheck) {
            movePlayer();
            if (checkEndGame()) {
                System.out.println("Congratulations!!! ");
                return;
            }
            moveMagistrMatches();
            if (checkEndGame()) {
                System.out.println("You are a loser (( ");
                return;
            }
        }
    }

    void moveMagistrMatches() {
        switch (data.getCount() % 4) {
            case 0 -> {
                System.out.println("Я убираю 3 спички ");
                data.value(3);
                System.out.println("осталось " + data.getCount());
            }
            case 1, 2 -> {
                System.out.print("Я убираю 1 спичку, ");
                data.value(1);
                System.out.println("осталось " + data.getCount());
            }
            case 3 -> {
                System.out.print("Я убираю 2 спички, ");
                data.value(2);
                System.out.println("осталось: " + data.getCount());
            }
        }
    }

    boolean checkValue(int variable) {
        if (variable < 1 || variable > 3) {
            System.out.println("число должно быть от 1 до 3 ");
            return false;
        }
        return true;
    }
}


