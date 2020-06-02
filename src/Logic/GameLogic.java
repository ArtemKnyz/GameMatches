package Logic;
import Data.Data;

public class GameLogic {

    private boolean checkEndGame;
    private boolean programExecutionCheck = true;
    Data data = new Data();
    PlayersLogic lg = new PlayersLogic();

    public void startGame() {
       data.setCount(20);
        System.out.println("На столе находится " + data.getCount() + " спичек.");
        while (programExecutionCheck) {
            data.stepExecution(lg.movePlayer());
            System.out.println("Осталось: " + data.getCount());
            if (checkEndGame()) {
                System.out.println("Для компьютера осталась одна спичка. Компьютер проиграл! ");
                return;
            }
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
