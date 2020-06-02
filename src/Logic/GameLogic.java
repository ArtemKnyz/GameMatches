package Logic;

import Data.Data;

import java.util.Scanner;

public class GameLogic {

    private boolean checkEndGame;
    private boolean programExecutionCheck = true;
    Data data = new Data();
    PlayersLogic lg = new PlayersLogic();

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        boolean startGame = false;
        System.out.print("Будете ходить первым? Введите  - (yes | (любой другой символ  - нет)): "); //default computer is a first
        if (scan.nextLine().equals("yes")) {
            startGame = true;
        }
        data.setCount(20);
        System.out.println("На столе находится " + data.getCount() + " спичек.");
        while (programExecutionCheck) {
            if (startGame) {
                data.stepExecution(lg.movePlayer());
                System.out.println("Осталось: " + data.getCount());
                if (checkEndGame()) {
                    System.out.println("Для компьютера осталась одна спичка. Компьютер проиграл! ");
                    return;
                }
            }
            startGame = true;
            int moveMagistr = (lg.moveMagistrMatches(data.getCount()));
            data.stepExecution(moveMagistr);
            System.out.println("- Количество выбранных компьютером спичек: " + moveMagistr);
            System.out.println("Осталось " + data.getCount());
            if (checkEndGame()) {
                System.out.println("Для игрока осталась одна спичка. Игрок проиграл! ");
                return;
            }
        }
    }

    boolean checkEndGame() {
        checkEndGame = false;
        if (data.getCount() == 1) {
            System.out.print("Игра окончена. ");
            checkEndGame = true;
        }
        return checkEndGame;
    }
}
