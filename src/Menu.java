import Logic.GameLogic;
import RuleGame.Rule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Menu {

    static Rule rule = new Rule();
    static GameLogic gameLogic = new GameLogic();

      void menuStart() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите одну из команд - (rule | start | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 ) {
                System.out.println("Неверная команда.");
                continue;
            }
            switch (params[0]) {
                case "rule":
                    System.out.println(rule.rule);
                    break;
                case "start":
                    gameLogic.startGame();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}

