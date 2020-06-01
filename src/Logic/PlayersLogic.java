package Logic;
import java.util.Scanner;

 class PlayersLogic {
    private int counterMovePlayer;

    int movePlayer() {
        Scanner scanner = new Scanner(System.in);
        boolean checkMovePlayer = false;
        while (!checkMovePlayer) {
            System.out.print("Ваш ход. Сколько спичек вы хотите убрать? ");
            try {
                counterMovePlayer = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("ввести нужно цифру! \n");
                scanner.nextLine();
                continue;
            }
            if (!checkValue(counterMovePlayer)) {
                continue;
            }
            checkMovePlayer = true;
        }
        return counterMovePlayer;
    }

    int moveMagistrMatches(int n) {
        switch (n % 4) {
            case 1, 2 -> {
                System.out.print("Я убираю 1 спичку, ");
                return 1;
            }
            case 3 -> {
                System.out.print("Я убираю 2 спички, ");
                return 2;
            }
        }
        System.out.println("Я убираю 3 спички ");
        return 3;
    }

     boolean checkValue(int variable) {
        if (variable < 1 || variable > 3) {
            System.err.println("число должно быть от 1 до 3 ");
            return false;
        }
        return true;
    }
}


