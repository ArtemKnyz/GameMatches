import Logic.LogicGame;
import RuleGame.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Rule rule = new Rule();
    static LogicGame logicGame = new LogicGame();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите одну из команд - (rule | level | start | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            switch (params[0]) {
                case "rule":
                    System.out.println(rule.rule);
                    break;
                case "start":
                    System.out.print("Вы хотите ходить первым? - (yes  |  no): ");
                    params = reader.readLine().trim().toLowerCase().split(" ");
                    if ((params.length < 1 || params.length > 2) || (!params[0].equals("yes") & !params[0].equals("no"))) {
                        System.out.println("Неверная команда.");
                        break;
                    } else if (params[0].equals("yes")) {
                        logicGame.setFirstMove(true);
                    } else if (params[0].equals("no")) {
                    }
                    logicGame.startGame();
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
