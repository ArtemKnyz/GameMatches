import Data.Data;
import Logic.LogicGame;
import RuleGame.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();
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
            String uuid = null;
            if (params.length == 2) {
                uuid = params[1].intern();
            }
            switch (params[0]) {
                case "rule":
                    System.out.println(rule.rule);
                    break;
                case "start":
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
