package Logic;
import Data.Data;

public class GameLogic {
    private boolean checkEndGame;
    private boolean programExecutionCheck = true;
    Data data = new Data();
    PlayersLogic lg = new PlayersLogic();

    public void startGame() {
       data.setCount(20);
        while (programExecutionCheck) {
            data.stepExecution(lg.movePlayer());
            System.out.println("осталось: " + data.getCount());
            if (checkEndGame()) {
                System.out.println("Congratulations!!! ");
                return;
            }
            data.stepExecution(lg.moveMagistrMatches(data.getCount()));
            System.out.println("осталось " + data.getCount());
            if (checkEndGame()) {
                System.out.println("You are a loser (( ");
                return;
            }
        }
    }

    boolean checkEndGame() {
        checkEndGame = false;
        if (data.getCount() == 1) {
            System.out.print("Game over! ");
            checkEndGame = true;
        }
        return checkEndGame;
    }
}
